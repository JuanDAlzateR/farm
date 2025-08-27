package com.solvd.farm.file;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class ReadFile {
    public static void main(String[] args) {

        File file = new File("src\\main\\resources\\input.txt");
        int count=0;
        try {

            String content = FileUtils.readFileToString(file, "UTF-8");

            String trimmedContent = StringUtils.trim(content);

            String[] lines = StringUtils.split(trimmedContent, System.lineSeparator());

            for (String line : lines) {
                String[] words = StringUtils.split(line," ");
                for(String word:words){

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Counts how many times a word it's repeated
     *in the file input.txt
     * @return the count for the word,
     * -1 if it finds an exception.
     */
    public static int countWordRepeat(String searchedWord) {

        File file = new File("src\\main\\resources\\input.txt");
        int count=-1;
        try {

            String content = FileUtils.readFileToString(file, "UTF-8");

            String formatedContent = StringUtils.trim(content).toLowerCase();

            count=StringUtils.countMatches(formatedContent,searchedWord.toLowerCase());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return count;
        }

    }
}
