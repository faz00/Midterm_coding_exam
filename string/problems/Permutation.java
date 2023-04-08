package string.problems;
import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static List<String> generatePermutations(String input) {
        List<String> result = new ArrayList<>();

        if (input == null || input.length() == 0) {
            return result;
        }

        generatePermutationsHelper(input.toCharArray(), 0, result);

        return result;
    }

    private static void generatePermutationsHelper(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            generatePermutationsHelper(chars, index + 1, result);
            swap(chars, i, index);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    public static void main(String[] args) {

        /*
         * Permutation of String "ABC" is "ABC" "BAC" "BCA" "ACB" "CAB" "CBA".
         * Write Java program to compute all Permutation of a String
         *
         */

        String input = "ABC";

        List<String> permutations = generatePermutations(input);

        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
