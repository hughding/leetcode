package pers.hugh.array.slidingwindow;

import java.util.*;

/**
 * @author dingxiuzheng
 */
public class FindAllAnagramsInAString {

    //438. Find All Anagrams in a String
    //https://leetcode.com/problems/find-all-anagrams-in-a-string/

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }


        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid += need.get(c);
                }
            }
            while (right - left >= p.length()) {
                if (valid == p.length()) {
                    result.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid -= need.get(d);
                    }
                    window.put(d, window.getOrDefault(d, 1) - 1);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsInAString().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new FindAllAnagramsInAString().findAnagrams("abab", "ab"));
        System.out.println(new FindAllAnagramsInAString().findAnagrams("baa", "aa"));
    }
}
