package pers.hugh.array.binarysearch;

/**
 * @author dingxiuzheng
 */
public class KokoEatingBananas {

    //875. Koko Eating Bananas
    //https://leetcode.com/problems/koko-eating-bananas/

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        //寻找左边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midHour = f(piles, mid);
            if (midHour == h) {
                right = mid - 1;
            } else if (midHour > h) {
                left = mid + 1;
            } else if (midHour < h) {
                right = mid - 1;
            }
        }
        return left;
    }

    public int f(int[] piles, int k) {
        int h = 0;
        for (int pile : piles) {
            h += pile / k + (pile % k > 0 ? 1 : 0);
        }
        if (h < 0) {
            return Integer.MAX_VALUE;
        }
        return h;
    }

    public static void main(String[] args) {
//        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
//        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
    }
}
