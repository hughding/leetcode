package pers.hugh.leetcode;

/**
 * @author hughding
 * @date 2020/5/3 15:57
 **/
public class LongestPalindromicSubstring {
//    5. Longest Palindromic Substring
//    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//    Example 1:
//
//    Input: "babad"
//    Output: "bab"
//    Note: "aba" is also a valid answer.
//            Example 2:
//
//    Input: "cbbd"
//    Output: "bb"

    //暴力破解法
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        int len = s.length();
        String palindromeStr = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                int start = i;
                int end = j;
                boolean isPalindrome = true;
                while (end > start) {
                    if (s.charAt(start) != s.charAt(end)) {
                        isPalindrome = false;
                        break;
                    }
                    start++;
                    end--;
                }
                if (isPalindrome) {
                    String subStr = s.substring(i, j + 1);
                    if (subStr.length() > palindromeStr.length()) {
                        palindromeStr = subStr;
                    }
                }
            }
        }
        return palindromeStr;
    }

    //矩阵,有问题
    public String longestPalindromeOpt(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        int len = s.length();

        int resultStartIndex = 0;
        int resultSubLen = 0;
        int startIndex = 0;
        int subLen = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == s.charAt(len - i - 1)) {
                if (startIndex == 0) {
                    startIndex = i;
                }
                subLen = i - startIndex + 1;
                if (subLen > resultSubLen) {
                    resultStartIndex = startIndex;
                    resultSubLen = subLen;
                }
            } else {
                startIndex = 0;
                subLen = 0;
            }
        }

        if (resultSubLen > 0) {
            return s.substring(resultStartIndex, resultSubLen);
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("a"));


        System.out.println(longestPalindromicSubstring.longestPalindrome("==============="));

        System.out.println(longestPalindromicSubstring.longestPalindromeOpt("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindromeOpt("cbbd"));
        System.out.println(longestPalindromicSubstring.longestPalindromeOpt("a"));
    }
}
