package pers.hugh.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dingxiuzheng
 */
public class PermutationInString {

    //567. Permutation in String
    //https://leetcode.com/problems/permutation-in-string/

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 1) - 1);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("ab", "eidbaooo"));
        System.out.println(new PermutationInString().checkInclusion("ab", "eidboaoo"));
        System.out.println(new PermutationInString().checkInclusion("hello", "ooolleoooleh"));
        System.out.println(new PermutationInString().checkInclusion("adc", "dcda"));
    }
}
