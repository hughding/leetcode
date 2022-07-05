package pers.hugh.leetcode;

/**
 * @author dingxiuzheng
 */
public class PalindromeNumber {

//    9. Palindrome Number
//
//    Given an integer x, return true if x is palindrome integer.
//
//    An integer is a palindrome when it reads the same backward as forward.
//
//    For example, 121 is a palindrome while 123 is not.
//
//
//    Example 1:
//
//    Input: x = 121
//    Output: true
//    Explanation: 121 reads as 121 from left to right and from right to left.
//            Example 2:
//
//    Input: x = -121
//    Output: false
//    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//    Example 3:
//
//    Input: x = 10
//    Output: false
//    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
//
//    Constraints:
//
//            -231 <= x <= 231 - 1
//
//
//    Follow up: Could you solve it without converting the integer to a string?

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int i = 1;
        int j = getDigitNum(x);
        while (j > i) {
            if (getDigit(x, j) != getDigit(x, i)) {
                return false;
            }
            j--;
            i++;
        }
        return true;
    }

    public int getDigitNum(int x) {
        int digitNum = 1;
        while (x / 10 > 0) {
            digitNum++;
            x = x / 10;
        }
        return digitNum;
    }

    public int tenPower(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * 10;
        }
        return result;
    }

    public int getDigit(int x, int n) {
        return x / tenPower(n - 1) % 10;
    }

    public static void main(String[] args) {

        System.out.println(new PalindromeNumber().isPalindrome(1410110141));
//        System.out.println(new PalindromeNumber().isPalindrome(121));
//        System.out.println(new PalindromeNumber().isPalindrome(-121));
//        System.out.println(new PalindromeNumber().isPalindrome(10));
//        System.out.println(new PalindromeNumber().isPalindrome(0));
//        System.out.println(new PalindromeNumber().isPalindrome(1410110141));
    }
}
