package com.solvd.farm.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
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
            boolean simpleWord = searchedWord.matches("\\w+");
            if (!simpleWord) {
                count = countByRegex(searchedWord.toLowerCase(), formatedContent);
            } else {
                count += Arrays.stream(lines)
                        .mapToInt(line -> countWordRepeatLine(searchedWord.toLowerCase(), line))
                        .sum();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return count;
        }

    }

    public static int countWordRepeatLine(String searchedWord, String line) {

        String[] words = line.split("\\W+");

        return (int) Arrays.stream(words)
                .filter(word -> word.equals(searchedWord))
                .count();
    }

    public static int countByRegex(String searchedWord, String content) {

        if (searchedWord == null || searchedWord.isEmpty()) {
            return 0;
        }

        String prefix = Character.isLetterOrDigit(searchedWord.charAt(0)) ? "\\b" : "";
        String suffix = Character.isLetterOrDigit(searchedWord.charAt(searchedWord.length() - 1)) ? "\\b" : "";
        String finalRegex = prefix + Pattern.quote(searchedWord) + suffix;

        Pattern pattern = Pattern.compile(finalRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static void write(String string) {
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
