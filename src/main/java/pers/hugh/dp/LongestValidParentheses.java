package pers.hugh.dp;

/**
 * @author hughding
 * @date 2020/8/26 19:28
 **/
public class LongestValidParentheses {

//    32. Longest Valid Parentheses
//
//    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
//    Example 1:
//
//    Input: "(()"
//    Output: 2
//    Explanation: The longest valid parentheses substring is "()"
//    Example 2:
//
//    Input: ")()())"
//    Output: 4
//    Explanation: The longest valid parentheses substring is "()()"

    //dp[i][j] = (dp[i+1][j-1] || (dp[i+2][j-2] && s[i] == ')' && s[j] = '(')) && s[i] == '(' && s[j] = ')'
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }

        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = false;
                }
                if (i == 0 && j > 0) {
                    if (j > 1) {
                        dp[0][j] = dp[1][j - 1] && s.charAt(0) == '(' && s.charAt(1) == ')';
                    } else {
                        dp[0][j] = s.charAt(0) == '(' && s.charAt(1) == ')';
                    }
                }
                if (i > 0 && j == 0) {
                    dp[i][j] = false;
                }
                if (i > 0 && j > 0) {
                    if (i + 1 <= j - 1) {
                        dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == '(' && s.charAt(j) == ')';
                    } else if (i <= j - 1) {
                        dp[i][j] = s.charAt(i) == '(' && s.charAt(j) == ')';
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
                if (dp[i][j] == true && j - 1 > end - start) {
                    start = i;
                    end = j;
                }
            }
        }

        return end - start + 1;
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}
