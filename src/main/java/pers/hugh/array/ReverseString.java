package pers.hugh.array;

import java.util.Arrays;

/**
 * @author dingxiuzheng
 */
public class ReverseString {

    //344. Reverse String
    //https://leetcode.com/problems/reverse-string/

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s1 = "hello".toCharArray();
        char[] s2 = "Hannaha".toCharArray();
        new ReverseString().reverseString(s1);
        System.out.println(Arrays.toString(s1));
        new ReverseString().reverseString(s2);
        System.out.println(Arrays.toString(s2));
    }
}
