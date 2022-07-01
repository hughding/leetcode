package pers.hugh.dp;

/**
 * @author dingxiuzheng
 */
public class NthTribonacciNumber {
//    1137. N-th Tribonacci Number
//
//    The Tribonacci sequence Tn is defined as follows:
//
//    T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
//    Given n, return the value of Tn.
//
//
//
//    Example 1:
//
//    Input: n = 4
//    Output: 4
//    Explanation:
//    T_3 = 0 + 1 + 1 = 2
//    T_4 = 1 + 1 + 2 = 4
//    Example 2:
//
//    Input: n = 25
//    Output: 1389537
//
//
//    Constraints:
//
//            0 <= n <= 37
//    The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int[] tn = new int[n + 1];
        tn[0] = 0;
        tn[1] = 1;
        tn[2] = 1;
        for (int i = 3; i <= n; i++) {
            tn[i] = tn[i - 1] + tn[i - 2] + tn[i - 3];
        }
        return tn[n];
    }

    public static void main(String[] args) {
        System.out.println(new NthTribonacciNumber().tribonacci(4));
        System.out.println(new NthTribonacciNumber().tribonacci(25));
    }
}
