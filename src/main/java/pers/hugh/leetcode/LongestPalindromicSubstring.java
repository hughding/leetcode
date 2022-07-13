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

    //dp[i,j] = dp[i+1,j-1] && s[i] == s[j]
    public String longestPalindromeOpt(String s) {
        int n = s.length();
        if (n == 0) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                if (i == 0 && j > 0) {
                    if (j > 1) {
                        dp[i][j] = dp[1][j - 1] && s.charAt(0) == s.charAt(j);
                    } else {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    }
                }
                if (i > 0 && j == 0) {
                    dp[i][j] = false;
                }
                if (i > 0 && j > 0) {
                    if (i + 1 <= j - 1) {
                        dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    } else if (i <= j) {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= i && dp[i][j] == true && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    //双指针
    public String longestPalindrome3(String s) {
        String p = "";
        for (int i = 0; i < s.length(); i++) {
            String p1 = palindrome(s, i, i + 1);
            if (p1.length() > p.length()) {
                p = p1;
            }
            String p2 = palindrome(s, i, i);
            if (p2.length() > p.length()) {
                p = p2;
            }
        }
        return p;
    }

    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("aa"));


        System.out.println(longestPalindromicSubstring.longestPalindrome("==============="));

        System.out.println(longestPalindromicSubstring.longestPalindromeOpt("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindromeOpt("cbbd"));
        System.out.println(longestPalindromicSubstring.longestPalindromeOpt("aa"));


        System.out.println(longestPalindromicSubstring.longestPalindrome("==============="));

        System.out.println(longestPalindromicSubstring.longestPalindrome3("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindrome3("cbbd"));
        System.out.println(longestPalindromicSubstring.longestPalindrome3("aa"));
    }
}
