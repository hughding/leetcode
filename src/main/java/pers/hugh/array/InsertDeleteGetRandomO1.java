package pers.hugh.array;

import java.util.*;

/**
 * @author dingxiuzheng
 */
public class InsertDeleteGetRandomO1 {

    //380. Insert Delete GetRandom O(1)
    //https://leetcode.com/problems/insert-delete-getrandom-o1/

    static class RandomizedSet {

        private Map<Integer, Integer> valToIndex;

        private List<Integer> list;

        private Random random;

        public RandomizedSet() {
            this.valToIndex = new HashMap<>();
            this.list = new ArrayList<>();
            this.random = new Random();
        }

        public boolean insert(int val) {
            if (valToIndex.containsKey(val)) {
                return false;
            }
            valToIndex.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)) {
                return false;
            }
            int i = valToIndex.get(val);
            valToIndex.put(list.get(list.size() - 1), i);
            swap(list, i, list.size() - 1);
            list.remove(list.size() - 1);
            valToIndex.remove(val);
            return true;
        }

        public int getRandom() {
            int i = random.nextInt(list.size());
            return list.get(i);
        }

        private void swap(List<Integer> list, int i, int j) {
            int tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
        }
    }

    public static void main(String[] args) {
        RandomizedSet r1 = new RandomizedSet();
        System.out.println(r1.insert(0));
        System.out.println(r1.insert(1));
        System.out.println(r1.remove(0));
        System.out.println(r1.insert(2));
        System.out.println(r1.remove(1));
        System.out.println(r1.getRandom());
    }
}
