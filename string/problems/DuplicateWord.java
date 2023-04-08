package string.problems;
import java.util.*;
public class DuplicateWord {

    public static void Duplicate(String str){

        String[] words = str.split("[\\s.,]+");
        Map<String, Integer> wordCounts = new HashMap<>();
        int totalLength = 0;
        for (String word : words) {
            Integer count = wordCounts.get(word.toLowerCase());
            if (count == null) {
                count = 0;
            }
            wordCounts.put(word.toLowerCase(), count + 1);
            totalLength += word.length();
        }
        int numWords = words.length;
        double avgLength = (double) totalLength / numWords;
        System.out.println("Duplicate words and their number of occurrences:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        System.out.println("Average word length: " + avgLength);

    }
    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         * Also Find the average length of the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
        Duplicate(st);
    }

}
