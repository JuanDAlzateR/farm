package com.solvd.farm.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

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
        write("Word: " + word + " | Count: " + count);

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
            count = StringUtils.countMatches(formatedContent, searchedWord.toLowerCase());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return count;
        }

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