package pers.hugh.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dingxiuzheng
 */
public class MinimumWindowSubstring {


    //76. Minimum Window Substring
    //https://leetcode.com/problems/minimum-window-substring/

    //暴力破解法,时间复杂度O(N^3)
    public String minWindow(String s, String t) {
        char[] sa = s.toCharArray();
        String result = "";
        for (int i = 0; i < sa.length; i++) {
            for (int j = i + 1; j <= sa.length; j++) {
                String subS = s.substring(i, j);
                if (contains(subS, t)) {
                    if (result.equals("")) {
                        result = subS;
                    } else if (result.length() > subS.length()) {
                        result = subS;
                    }
                }
            }
        }
        return result;
    }

    public boolean contains(String subS, String t) {

        char[] a1 = subS.toCharArray();
        char[] a2 = t.toCharArray();
        Map<Character, Integer> subMap = new HashMap<>();
        for (int i = 0; i < a1.length; i++) {
            subMap.put(a1[i], subMap.getOrDefault(a1[i], 0) + 1);
        }
        for (int i = 0; i < a2.length; i++) {
            Integer value = subMap.get(a2[i]);
            if (value == null || value == 0) {
                return false;
            } else {
                subMap.put(a2[i], value - 1);
            }
        }
        return true;
    }

    //滑动窗口
    public String minWindow2(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        String result = "";
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (intEquals(need.get(c), window.get(c))) {
                valid++;
            }
            System.out.println("window:" + s.substring(left, right));
            while (valid == need.size()) {
                //获取最小子串
                if ("".equals(result)) {
                    result = s.substring(left, right);
                } else if (result.length() > right - left) {
                    result = s.substring(left, right);
                }

                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 1) - 1);
                if (need.containsKey(d) && need.get(d).compareTo(window.get(d)) > 0){
                    valid--;
                }
            }
        }
        return result;
    }

    public boolean intEquals(Integer i1, Integer i2) {
        if (i1 == null) {
            return i2 == null;
        }
        return i1.equals(i2);
    }

    public static void main(String[] args) {
//        System.out.println("result:" + new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println("result:" + new MinimumWindowSubstring().minWindow("a", "a"));
//        System.out.println("result:" + new MinimumWindowSubstring().minWindow("bba", "ab"));
//        System.out.println("===================================");
//        System.out.println("result:" + new MinimumWindowSubstring().minWindow2("ADOBECODEBANC", "ABC"));
//        System.out.println("result:" + new MinimumWindowSubstring().minWindow2("a", "a"));
//        System.out.println("result:" + new MinimumWindowSubstring().minWindow2("bba", "ab"));
        System.out.println("result:" + new MinimumWindowSubstring().minWindow2("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}
