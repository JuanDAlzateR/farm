package com.solvd.farm.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

import com.solvd.farm.Main;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ReadFile {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text ="a b .jar c d";
        String exp="(pom)";
        boolean matches=exp.matches("\\w+");
        LOGGER.info("word matches: "+matches);
        String[] parts= StringUtils.split(text,".jar");
        for (String part:parts) {
            LOGGER.info(part);
        }
        LOGGER.info("Please input the word to search in input.txt");
        String word = scanner.nextLine();
        int count = countWordRepeat(word);
        if (count >= 0) {
            write("Word: " + word + ". Count: " + count);
        } else {
            write("Word: " + word + ".");
            LOGGER.warn("File input.txt couldn't be read");
        }
    }

    /**
     * Counts how many times a word it's repeated
     * in the file input.txt
     *
     * @return the count for the word,
     * -1 if it finds an exception.
     */
    public static int countWordRepeat(String searchedWord) {

        File file = new File("src\\main\\resources\\input.txt");
        int count = -1;
        try {
            String content = FileUtils.readFileToString(file, "UTF-8");
            String formatedContent = StringUtils.trim(content).toLowerCase();
            String[] lines = StringUtils.split(formatedContent, System.lineSeparator());
            count = 0;
            boolean matches=searchedWord.matches("\\w+");
            if (!matches) {
                count = countBySplit(searchedWord.toLowerCase(), formatedContent);
            } else {
                for (String line : lines) {
                    count += countWordRepeatLine(searchedWord.toLowerCase(), line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return count;
        }

    }

    public static int countWordRepeatLine(String searchedWord, String line) {

        int count = 0;
        String[] words = line.split("\\W+");

        for (String word : words) {
            if (word.equals(searchedWord))
                count++;
        }
        return count;
    }

    public static int countBySplit(String searchedWord, String content) {
        String pattern= Pattern.quote(searchedWord);
        LOGGER.debug(pattern);
        String[] lines = content.split("\\b" + pattern + "\\b");
        return lines.length - 1;
    }

    /**
     * Counts how many times a word it's repeated
     * in the file input.txt
     *
     * @return true if the expression it's complex, for example: don't, C++, A/B.
     * false if the expression it's a simple word.
     */
    public static boolean complexWord(String searchedWord) {

        String[] parts = searchedWord.split("\\W+");
        if (parts.length > 1) {
            return true;
        } else {
            return false;
        }
    }

        public static void write (String string){
            try {
                File file = new File("target/output/output.txt");
                // Make sure the folder exists
                FileUtils.forceMkdirParent(file);

                String finalText = StringUtils.trim(string);

                FileUtils.writeStringToFile(file, finalText + System.lineSeparator(), StandardCharsets.UTF_8, true);

                LOGGER.info("File updated in: " + file.getAbsolutePath());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
