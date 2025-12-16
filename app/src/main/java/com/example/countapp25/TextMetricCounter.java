package com.example.countapp25; // Adjust to your package name

/**
 * Separate class for text metrics counting logic.
 * Uses regex for Sentences and Words; no regex for Chars and Numbers.
 * All methods handle null/empty input by returning 0.
 */
public class TextMetricCounter {

    /**
     * Counts sentences using regex split on sentence-ending punctuation
     * followed by whitespace or end-of-string.
     *
     * @param text The input text to analyze.
     * @return Number of sentences (approximate).
     */
    public static int countSentences(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        // Regex: Split after . ! ? if followed by space or end ($)
        String[] sentences = text.split("[.!?](?=\\s|$)");
        return sentences.length;
    }

    /**
     * Counts words using regex split on one or more spaces, commas, or dots.
     *
     * @param text The input text to analyze.
     * @return Number of words.
     */
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        // Regex: Split on [ \s, . ]+ (spaces, commas, dots; \s for whitespace)
        String[] words = text.split("[\\s,.]+");
        // Filter out any empty strings (e.g., multiple separators)
        int wordCount = 0;
        for (String word : words) {
            if (!word.trim().isEmpty()) {
                wordCount++;
            }
        }
        return wordCount;
    }

    /**
     * Counts total characters (including spaces and punctuation) without regex.
     *
     * @param text The input text to analyze.
     * @return Number of characters.
     */
    public static int countCharacters(String text) {
        return text != null ? text.length() : 0;
    }

    /**
     * Counts individual digits (0-9) without regex, using a loop.
     *
     * @param text The input text to analyze.
     * @return Number of digits.
     */
    public static int countNumbers(String text) {
        if (text == null) {
            return 0;
        }
        int digitCount = 0;
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        return digitCount;
    }

    public static int countUppercaseWords(String text) {
        if (text == null || text.trim().isEmpty()) return 0;
        String[] words = text.split("\\s+");
        int count = 0;

        for (String word : words) {
            word = word.replaceAll("[^A-Z]", ""); // remove punctuation
            if (!word.isEmpty() && word.equals(word.toUpperCase())) {
                count++;
            }
        }
        return count;
    }
}