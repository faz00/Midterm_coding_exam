package string.problems;

import java.util.HashMap;
import java.util.Map;

public class DetermineLargestWord {
        public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below.
         Should return "10 biological".
         */
        String s="Human brain is a biological learning machine";
        Map<Integer, String> wordNLength = findTheLargestWord(s);
        //implement

            System.out.println(findTheLargestWord(s));

    }

    public static Map<Integer, String> findTheLargestWord(String s) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        String st = "";
        //implement
        String[] words = s.split("\\s+");

        // Initialize variables for the longest word and its length
        String longestWord = "";
        int longestLength = 0;

        // Iterate through each word in the sentence
        for (String word : words) {
            // Remove any punctuation from the word
            word = word.replaceAll("[^a-zA-Z0-9]", "");

            // If the word is longer than the current longest word, update the variables
            if (word.length() > longestLength) {
                longestWord = word;
                longestLength = word.length();
            }


        }
        ;
        map.put(longestLength, longestWord);

        return map;
    }
}
