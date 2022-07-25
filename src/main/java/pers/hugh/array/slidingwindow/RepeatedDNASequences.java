package pers.hugh.array.slidingwindow;

import java.util.*;

/**
 * @author dingxiuzheng
 */
public class RepeatedDNASequences {

    //187. Repeated DNA Sequences
    //https://leetcode.com/problems/repeated-dna-sequences/

    //O(N*10)

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String subS = s.substring(i, i + 10);
            if (seen.contains(subS)) {
                res.add(subS);
            } else {
                seen.add(subS);
            }
        }
        return new ArrayList<>(res);
    }

    //O(N),不算给res添加字串的操作
    //AGCT = 0123

    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> res = new HashSet<>();
        int window = 0;
        int left = 0, right = 0;
        Set<Integer> seen = new HashSet<>();
        int RL = (int) Math.pow(4, 9);
        while (right < s.length()) {
            char c = s.charAt(right);
            window = window * 4 + getNum(c);
            right++;

            if (right - left == 10) {
                if (seen.contains(window)) {
                    res.add(s.substring(left, right));
                }
                seen.add(window);

                char d = s.charAt(left);
                window = window - getNum(d) * RL;
                left++;
            }
        }
        return new ArrayList<>(res);
    }

    private int getNum(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'G':
                return 1;
            case 'C':
                return 2;
            case 'T':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        //result="AAAAACCCCC","CCCCCAAAAA"
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        //result="AAAAAAAAAAAAA"
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        //result="AAAAAAAAAAAAA"
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAA"));
        //result="AAAAACCCCC","CCCCCAAAAA"
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        //result="AAAAAAAAAAAAA"
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences2("AAAAAAAAAAAAA"));
        //result="AAAAAAAAAAAAA"
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences2("AAAAAAAAAAA"));
    }
}
