package pers.hugh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class StringToInteger {

//    8. String to Integer (atoi)
//
//    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
//
//            The algorithm for myAtoi(string s) is as follows:
//
//    Read in and ignore any leading whitespace.
//            Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
//    Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
//    Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
//    If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
//    Return the integer as the final result.
//            Note:
//
//    Only the space character ' ' is considered a whitespace character.
//    Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
//
//
//            Example 1:
//
//    Input: s = "42"
//    Output: 42
//    Explanation: The underlined characters are what is read in, the caret is the current reader position.
//    Step 1: "42" (no characters read because there is no leading whitespace)
//            ^
//    Step 2: "42" (no characters read because there is neither a '-' nor '+')
//            ^
//    Step 3: "42" ("42" is read in)
//            ^
//    The parsed integer is 42.
//    Since 42 is in the range [-231, 231 - 1], the final result is 42.
//    Example 2:
//
//    Input: s = "   -42"
//    Output: -42
//    Explanation:
//    Step 1: "   -42" (leading whitespace is read and ignored)
//            ^
//    Step 2: "   -42" ('-' is read, so the result should be negative)
//            ^
//    Step 3: "   -42" ("42" is read in)
//            ^
//    The parsed integer is -42.
//    Since -42 is in the range [-231, 231 - 1], the final result is -42.
//    Example 3:
//
//    Input: s = "4193 with words"
//    Output: 4193
//    Explanation:
//    Step 1: "4193 with words" (no characters read because there is no leading whitespace)
//            ^
//    Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
//            ^
//    Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
//            ^
//    The parsed integer is 4193.
//    Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
//
//
//    Constraints:
//
//            0 <= s.length <= 200
//    s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

    public int myAtoi(String s) {
        int result = 0;
        boolean negative = false;
        int index = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                index++;
            } else {
                break;
            }
        }

        if (index < charArray.length) {
            if (charArray[index] == '+') {
                index++;
            } else if (charArray[index] == '-') {
                index++;
                negative = true;
            }
        }


        for (int i = index; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                index++;
            } else {
                break;
            }
        }

        List<Character> list = new ArrayList<>();
        for (int i = index; i < charArray.length; i++) {
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                list.add(charArray[i]);
            } else {
                break;
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            char c = list.get(i);
            int tenPower = list.size() - 1 - i;
            if (c >= '0' && c <= '9') {
                if(tenPower > 9){
                    result = -1;
                    break;
                }
                if(tenPower == 9 && (c - '0') > 2){
                    result = -1;
                    break;
                }

                int mutipluy = tenPower(list.size() - 1 - i);
                if (mutipluy == Integer.MAX_VALUE) {
                    result = -1;
                    break;
                }
                result += (c - '0') * mutipluy;
            }
        }
        //溢出
        if (result < 0) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return negative ? -result : result;
    }

    //n>9时会溢出
    public int tenPower(int n) {
        if (n > 9) {
            return Integer.MAX_VALUE;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("-6147483648"));
        System.out.println(new StringToInteger().myAtoi("21474836460"));
        System.out.println(new StringToInteger().myAtoi("-91283472332"));
        System.out.println(new StringToInteger().myAtoi("42"));
        System.out.println(new StringToInteger().myAtoi("     -42"));
        System.out.println(new StringToInteger().myAtoi("4193 with words"));
        System.out.println(new StringToInteger().myAtoi("-91283472332"));
        System.out.println(new StringToInteger().myAtoi("2147483647"));
        System.out.println(new StringToInteger().myAtoi("-2147483648"));
        System.out.println(new StringToInteger().myAtoi("+-12"));
        System.out.println(new StringToInteger().myAtoi("00000-42a1234"));
        System.out.println(new StringToInteger().myAtoi("  0000000000012345678"));
        System.out.println(new StringToInteger().myAtoi("21474836460"));
        System.out.println(new StringToInteger().myAtoi("   +0 123"));
        System.out.println(new StringToInteger().myAtoi(""));
        System.out.println(new StringToInteger().myAtoi("2147483648"));
    }
}
