package pers.hugh.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author dingxiuzheng
 */
public class RandomPickWithBlacklist {

    //710. Random Pick with Blacklist
    //https://leetcode.com/problems/random-pick-with-blacklist/

    static class Solution {

        private Random random;

        private Map<Integer, Integer> valN;

        private int last;

        public Solution(int n, int[] blacklist) {
            this.random = new Random();
            this.valN = new HashMap<>(blacklist.length * 4);
            this.last = n - blacklist.length;
            for (int black : blacklist) {
                valN.put(black, 0);
            }
            n--;
            for (int black : blacklist) {
                if(black < last){
                    while (valN.containsKey(n)) {
                        n--;
                    }
                    valN.put(black, n);
                    n--;
                }
            }
        }

        public int pick() {
            int r = random.nextInt(last);
            Integer n = valN.get(r);
            return n == null ? r : n;
        }
    }

    public static void main(String[] args) {
        Solution s1 = new Solution(7, new int[]{2, 3, 5});
        for (int i = 0; i < 10; i++) {
            System.out.println(s1.pick());
        }
    }
}
