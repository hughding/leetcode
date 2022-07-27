package pers.hugh.array;

import java.util.Stack;

/**
 *
 * same as
 * @see SmallestSubsequenceOfDistinctCharacters
 *
 * @author dingxiuzheng
 */
public class RemoveDuplicateLetters {

    //316. Remove Duplicate Letters
    //https://leetcode.com/problems/remove-duplicate-letters/

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = c - 'a';
            count[j]++;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = c - 'a';
            count[j]--;

            if (inStack[j]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek() - 'a'] == 0) {
                    break;
                }
                char p = stack.pop();
                inStack[p - 'a'] = false;
            }
            stack.push(c);
            inStack[j] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("bcabc"));
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));
    }
}
