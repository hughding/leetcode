package pers.hugh.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class PascalsTriangle {

//    118. Pascal's Triangle
//
//    Given an integer numRows, return the first numRows of Pascal's triangle.
//
//    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//
//
//
//    Example 1:
//
//    Input: numRows = 5
//    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//    Example 2:
//
//    Input: numRows = 1
//    Output: [[1]]
//
//
//    Constraints:
//
//            1 <= numRows <= 30

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> preRow = result.get(i - 1);
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j - 1 < 0 || j >= preRow.size()) {
                    row.add(1);
                } else {
                    row.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(5));
    }
}
