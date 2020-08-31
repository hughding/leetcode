package pers.hugh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hughding
 * @date 2020/8/31 16:43
 **/
public class LetterCombinationsofaPhoneNumber {
//    17. Letter Combinations of LetterCombinationsofaPhoneNumber Phone Number
//    Medium

//    Given LetterCombinationsofaPhoneNumber string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
//    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//    Example:
//
//    Input: "23"
//    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//    Note:
//
//    Although the above answer is in lexicographical order, your answer could be in any order you want.

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        doCombination(new StringBuilder(), digits, combinations);
        return combinations;
    }

    private void doCombination(StringBuilder prefix, String digits, List<String> combinations) {
        if (prefix.length() == digits.length()) {
            combinations.add(prefix.toString());
            return;
        }

        int curDigit = digits.charAt(prefix.length()) - '0';
        String curKeys = KEYS[curDigit];
        for (char c : curKeys.toCharArray()) {
            prefix.append(c);
            doCombination(prefix, digits, combinations);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber solution = new LetterCombinationsofaPhoneNumber();
        System.out.println(solution.letterCombinations("23"));
    }
}
