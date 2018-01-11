package pers.hugh.leetcode;

/**
 * @author hugh
 * @version 1.0
 * @since <pre>2017/12/14</pre>
 */
public class RegularExpressionMatching {
    //    10. Regular Expression Matching
//    Implement regular expression matching with support for '.' and '*'.
//
//            '.' Matches any single character.
//            '*' Matches zero or more of the preceding element.
//
//    The matching should cover the entire input string (not partial).
//
//    The function prototype should be:
//    bool isMatch(const char *s, const char *p)
//
//    Some examples:
//    isMatch("aa","a") → false
//    isMatch("aa","aa") → true
//    isMatch("aaa","aa") → false
//    isMatch("aa", "a*") → true
//    isMatch("aa", ".*") → true
//    isMatch("ab", ".*") → true
//    isMatch("aab", "c*a*b") → true

    /**
     * 改进
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        s = " " + s;
        p = " " + p;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j > 1 && p.charAt(j) == '*') {
                    dp[i][j] = dp[i][j - 2] || (i > 0 && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i - 1][j]);
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m - 1][n - 1];
    }

    /**
     * CSDN介绍源码
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (j > 1 && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("ab", ".*c"));
        System.out.println(new RegularExpressionMatching().isMatch2("ab", ".*c"));
    }
}
