package string.problems;
import java.util.Arrays;
public class Anagram {
         public static Boolean CheckAnagram(String s1 , String s2){
             s1 = s1.toLowerCase().replaceAll("\\s", "");
             s2 = s2.toLowerCase().replaceAll("\\s", "");

             // Convert both strings to character arrays and sort them
             char[] s1Chars = s1.toCharArray();
             Arrays.sort(s1Chars);
             char[] s2Chars = s2.toCharArray();
             Arrays.sort(s2Chars);

             // Check if the sorted arrays are equal
             boolean isAnagram = Arrays.equals(s1Chars, s2Chars);

             return isAnagram;
         }
    public static void main(String[] args) {
        //Write a Java Program to check if the two String are Anagram. Two String are called Anagram when there is
        //same character but in different order.For example,"CAT" and "ACT", "ARMY" and "MARY".

        String str1="CAT", str2="TAC";

        if (CheckAnagram(str1,str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }



         }
}
