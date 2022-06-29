package pers.hugh.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class PascalsTriangleII {

//    119. Pascal's Triangle II
//
//    Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
//
//    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//
//
//
//    Example 1:
//
//    Input: rowIndex = 3
//    Output: [1,3,3,1]
//    Example 2:
//
//    Input: rowIndex = 0
//    Output: [1]
//    Example 3:
//
//    Input: rowIndex = 1
//    Output: [1,1]
//
//
//    Constraints:
//
//            0 <= rowIndex <= 33

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> preRow = result.get(i - 1);
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            result.add(row);
        }
        return result.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleII().getRow(3));
        System.out.println(new PascalsTriangleII().getRow(0));
        System.out.println(new PascalsTriangleII().getRow(1));
    }
}
