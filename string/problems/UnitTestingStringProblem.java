package string.problems;

import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class UnitTestingStringProblem {
    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Anagram");
            System.out.println("2. DetermineLargestWord");
            System.out.println("3. Palindrome");
            System.out.println("4. Permutation");
            System.out.println("5. DuplicateWord");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    String str1="CAT", str2="TAC";

                    if (Anagram.CheckAnagram(str1,str2)) {
                        System.out.println(str1 + " and " + str2 + " are anagrams.");
                    } else {
                        System.out.println(str1 + " and " + str2 + " are not anagrams.");
                    }
                    break;
                case 2:
                    System.out.println("The Largest Word is: ");
                    //2
                    String s="Human brain is a biological learning machine";
                    Map<Integer, String> wordNLength = DetermineLargestWord.findTheLargestWord(s);
                    //implement

                    System.out.println(DetermineLargestWord.findTheLargestWord(s));
                    break;
                case 3:
                    System.out.println("Palindrome: ");
                    //3
                    String s2="MOM";

                    System.out.println(Palindrome.isPalindrom(s2));
                    break;
                case 4:
                    System.out.println("Permutation: ");
                    //4
                    String input = "ABC";

                    List<String> permutations = Permutation.generatePermutations(input);

                    for (String permutation : permutations) {
                        System.out.println(permutation);
                    }
                    break;
                case 5:
                    System.out.println("DuplicateWord");
                    String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
                    DuplicateWord.Duplicate(st);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 6);

    }
}
