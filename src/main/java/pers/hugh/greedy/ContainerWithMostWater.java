package pers.hugh.greedy;

/**
 * @author dingxiuzheng
 */
public class ContainerWithMostWater {
    //
//    11. Container With Most Water
//    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//    Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//    Return the maximum amount of water a container can store.
//
//    Notice that you may not slant the container.
//
//
//
//    Example 1:
//
//
//    Input: height = [1,8,6,2,5,4,8,3,7]
//    Output: 49
//    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
//    Example 2:
//
//    Input: height = [1,1]
//    Output: 1
//
//
//    Constraints:
//
//    n == height.length
//    2 <= n <= 105
//    0 <= height[i] <= 104
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int h1 = height[i];
            for (int j = height.length - 1; j > i; j--) {
                int h2 = height[j];
                int s = Math.min(h1, h2) * (j - i);
                if (s > max) {
                    max = s;
                }
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (j > i) {
            int s = Math.min(height[i], height[j]) * (j - i);
            if (s > max) {
                max = s;
            }
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 1}));
        System.out.println(new ContainerWithMostWater().maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new ContainerWithMostWater().maxArea2(new int[]{1, 1}));
    }
}
