package pers.hugh.array;

/**
 * @author dingxiuzheng
 */
public class CapacityToShipPackagesWithinDDays {

    //1011. Capacity To Ship Packages Within D Days
    //https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

    private int minCapacity;

    public int shipWithinDays(int[] weights, int days) {
        minCapacity = Integer.MAX_VALUE;
        track(weights, days, 0, 0);
        return minCapacity;
    }

    private void track(int[] weights, int days, int start, int preMaxCapacity) {
        if (days == 0) {
            if (start == weights.length) {
                minCapacity = Math.min(minCapacity, preMaxCapacity);
            }
            return;
        }
        int capacity = 0;
        for (int i = start; i <= weights.length - days; i++) {
            capacity += weights[i];
            track(weights, days - 1, i + 1, Math.max(capacity, preMaxCapacity));
        }
    }

    public int shipWithinDays2(int[] weights, int days) {
        int left = weights[0], right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        //寻找左边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int fMid = f(weights, mid);
            if (fMid == days) {
                right = mid - 1;
            } else if (fMid < days) {
                right = mid - 1;
            } else if (fMid > days) {
                left = mid + 1;
            }
        }
        return left;
    }

    public int f(int[] weights, int capacity) {
        int days = 1;
        int transfer = 0;
        for (int weight : weights) {
            if (transfer + weight > capacity) {
                days++;
                transfer = weight;
            } else {
                transfer += weight;
            }
        }
        return days;
    }

    public static void main(String[] args) {
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
        System.out.println("============================");
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays2(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays2(new int[]{1, 2, 3, 1, 1}, 4));
    }

}
