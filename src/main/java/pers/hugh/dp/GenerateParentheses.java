package pers.hugh.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class GenerateParentheses {


//    22. Generate Parentheses
//
//    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
//    Example 1:
//
//    Input: n = 3
//    Output: ["((()))","(()())","(())()","()(())","()()()"]
//    Example 2:
//
//    Input: n = 1
//    Output: ["()"]
//
//
//    Constraints:
//
//            1 <= n <= 8

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(new char[n * 2], 0, result);
        return result;
    }

    private void generate(char[] combinations, int pos, List<String> result) {
        if (pos == combinations.length) {
            if (isValid(combinations)) {
                result.add(String.valueOf(combinations));
            }
        } else {
            combinations[pos] = '(';
            generate(combinations, pos + 1, result);
            combinations[pos] = ')';
            generate(combinations, pos + 1, result);
        }
    }

    private boolean isValid(char[] combinations) {
        int left = 0;
        int right = 0;
        for (char c : combinations) {
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
            if (right > left) {
                return false;
            }
        }
        return left == right;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(1));
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
