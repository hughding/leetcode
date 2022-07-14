package pers.hugh.array.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
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
//    https://leetcode.com/problems/longest-substring-without-repeating-characters/

    /**
     * O(n^3) Time Limit Exceeded
     *
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

    //滑动窗口 O(N)
    public int lengthOfLongestSubstringSlidingWindow(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int result = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 1) - 1);
            }
            result = Math.max(result, right - left);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(""));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("c"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("au"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));

        System.out.println("=============================================");

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringSlidingWindow(""));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringSlidingWindow("c"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringSlidingWindow("au"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringSlidingWindow("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringSlidingWindow("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringSlidingWindow("pwwkew"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringSlidingWindow("nfpdmpi"));
    }
}
