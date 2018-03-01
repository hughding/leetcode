package pers.hugh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author xzding
 * @version 1.0
 * @since <pre>2018/3/1</pre>
 */
public class LongestSubstringWithoutRepeatingCharacters {
//    3. Longest Substring Without Repeating Characters
//    Given a string, find the length of the longest substring without repeating characters.
//
//    Examples:
//
//    Given "abcabcbb", the answer is "abc", which the length is 3.
//
//    Given "bbbbb", the answer is "b", with the length of 1.
//
//    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

    /**
     * O(n^3) Time Limit Exceeded
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            List<Character> characterList = new ArrayList<>();
            characterList.add(s.charAt(i));
            for (int j = i + 1; j < s.length() + 1; j++) {
                if (j >= s.length() || characterList.contains(s.charAt(j))) {
                    max = Math.max(j - i, max);
                    break;
                } else {
                    characterList.add(s.charAt(j));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(""));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("c"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("au"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
    }
}
