package pers.hugh.leetcode;

/**
 * @author hughding
 * @date 2020/9/18 15:46
 **/
public class SumOfSquareNumbers {
//    633. Sum of Square Numbers
//
//    Add to List
//
//            Share
//    Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = c;
        boolean has = false;

        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == c) {
                has = true;
                break;
            } else if (sum < c) {
                i++;
            } else {
                j--;
            }
        }

        return has;
    }

    public static void main(String[] args) {
        SumOfSquareNumbers solution = new SumOfSquareNumbers();
        System.out.println(solution.judgeSquareSum(1));
        System.out.println(solution.judgeSquareSum(5));
        System.out.println(solution.judgeSquareSum(3));
    }
}
