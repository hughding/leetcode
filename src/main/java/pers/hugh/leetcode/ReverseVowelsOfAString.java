package pers.hugh.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hughding
 * @date 2020/9/18 20:43
 **/
public class ReverseVowelsOfAString {
//    345. Reverse Vowels of a String
//
//    Write a function that takes a string as input and reverse only the vowels of a string.

    private static final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'o', 'e', 'i', 'u', 'A', 'O', 'E', 'I', 'U'));

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ic = s.charAt(i);
            char jc = s.charAt(j);
            if (!vowels.contains(ic)) {
                result[i] = ic;
                i++;
            }
            if (!vowels.contains(jc)) {
                result[j] = jc;
                j--;
            }
            if (vowels.contains(ic) && vowels.contains(jc)) {
                result[i] = jc;
                result[j] = ic;
                i++;
                j--;
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString solution = new ReverseVowelsOfAString();
        System.out.println(solution.reverseVowels("hello"));
        System.out.println(solution.reverseVowels("leetcode"));
        System.out.println(solution.reverseVowels(" "));
    }
}
