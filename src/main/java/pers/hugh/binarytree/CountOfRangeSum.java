package pers.hugh.binarytree;

/**
 * @author dingxiuzheng
 */
public class CountOfRangeSum {

    //327. Count of Range Sum
    //https://leetcode.com/problems/count-of-range-sum/

    //TLE
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    res++;
                }
            }
        }
        return res;
    }

    private long[] tmp;

    private int count;

    private int lower;

    private int upper;

    public int countRangeSum2(int[] nums, int lower, int upper) {
        this.tmp = new long[nums.length + 1];
        this.count = 0;
        this.lower = lower;
        this.upper = upper;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + (long) nums[i];
        }
        sort(preSum, 0, preSum.length - 1);
        return count;
    }

    private void sort(long[] preSum, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(preSum, low, mid);
        sort(preSum, mid + 1, high);
        merge(preSum, low, high, mid);
    }

    private void merge(long[] preSum, int low, int high, int mid) {
//        for (int i = low; i <= mid; i++) {
//            for (int j = mid + 1; j <= high; j++) {
//                long sum = preSum[j] - preSum[i];
//                if (sum >= lower && sum <= upper) {
//                    count++;
//                }
//            }
//        }

        int start = mid + 1, end = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (start <= high && preSum[start] - preSum[i] < lower) {
                start++;
            }
            while (end <= high && preSum[end] - preSum[i] <= upper) {
                end++;
            }
            count += end - start;
        }

        int i = low;
        int j = mid + 1;
        int p = low;
        while (p <= high) {
            if (i > mid) {
                tmp[p++] = preSum[j++];
            } else if (j > high) {
                tmp[p++] = preSum[i++];
            } else if (preSum[i] <= preSum[j]) {
                tmp[p++] = preSum[i++];
            } else if (preSum[i] > preSum[j]) {
                tmp[p++] = preSum[j++];
            }
        }
        for (p = low; p <= high; p++) {
            preSum[p] = tmp[p];
        }
    }


    public static void main(String[] args) {
        CountOfRangeSum countOfRangeSum = new CountOfRangeSum();
        System.out.println(countOfRangeSum.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
        System.out.println(countOfRangeSum.countRangeSum(new int[]{0}, 0, 0));
        System.out.println(countOfRangeSum.countRangeSum2(new int[]{-2, 5, -1}, -2, 2));
        System.out.println(countOfRangeSum.countRangeSum2(new int[]{0}, 0, 0));
    }
}
