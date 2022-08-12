package pers.hugh.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author dingxiuzheng
 */
public class FlattenNestedListIterator {

    //341. Flatten Nested List Iterator
    //https://leetcode.com/problems/flatten-nested-list-iterator/

    public static class NestedIterator implements Iterator<Integer> {

        private Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            List<Integer> list = new ArrayList<>();
            for (NestedInteger item : nestedList) {
                traverse(item, list);
            }
            iterator = list.iterator();
        }

        private void traverse(NestedInteger node, List<Integer> list) {
            if (node.isInteger()) {
                list.add(node.getInteger());
                return;
            }
            for (NestedInteger item : node.getList()) {
                traverse(item, list);
            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

    public static class NestedIterator2 implements Iterator<Integer> {

        private List<NestedInteger> nestedList;

        public NestedIterator2(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
        }

        @Override
        public Integer next() {
            return nestedList.remove(0).getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!nestedList.isEmpty() && !nestedList.get(0).isInteger()) {
                List<NestedInteger> list = nestedList.remove(0).getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    nestedList.add(0, list.get(i));
                }
            }
            return !nestedList.isEmpty();
        }
    }

    public static class NestedInteger {
        private Integer val;
        private List<NestedInteger> list;

        public NestedInteger(Integer val, List<NestedInteger> list) {
            this.val = val;
            this.list = list;
        }

        public boolean isInteger() {
            return val != null;
        }

        public Integer getInteger() {
            return val;
        }

        public List<NestedInteger> getList() {
            return list;
        }
    }

    public static void main(String[] args) {
        List<NestedInteger> list = Arrays.asList(
                new NestedInteger(null, Arrays.asList(new NestedInteger(1, null), new NestedInteger(1, null))),
                new NestedInteger(2, null),
                new NestedInteger(null, Arrays.asList(new NestedInteger(1, null), new NestedInteger(1, null))));
        NestedIterator iterator = new NestedIterator(list);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("=================");

        List<NestedInteger> list2 = new ArrayList<>();
        List<NestedInteger> tmp = new ArrayList<>();
        tmp.add(new NestedInteger(1, null));
        tmp.add(new NestedInteger(1, null));
        list2.add(new NestedInteger(null, tmp));
        list2.add(new NestedInteger(2, null));
        tmp = new ArrayList<>();
        tmp.add(new NestedInteger(1, null));
        tmp.add(new NestedInteger(1, null));
        list2.add(new NestedInteger(null, tmp));
        NestedIterator2 iterator2 = new NestedIterator2(list2);
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
