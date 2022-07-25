package pers.hugh.array.slidingwindow;

/**
 * @author dingxiuzheng
 */
public class ImplementStrStr {

    //28. Implement strStr()
    //https://leetcode.com/problems/implement-strstr/submissions/
    //Rabin-Carp算法=滑动窗口+hash

    private static final int MOD = Integer.MAX_VALUE / 100;
    private static final int R = 27;

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        int RL = 1;
        for (int i = 0; i < needle.length() - 1; i++) {
            RL = (RL * R) % MOD;
        }

        int needleHash = 0;
        for (int i = 0; i < needle.length(); i++) {
            char c = needle.charAt(i);
            needleHash = (needleHash * R + (c - 'a' + 1)) % MOD;
        }


        int windowHash = 0;
        int left = 0, right = 0;
        while (right < haystack.length()) {
            char c = haystack.charAt(right);
            windowHash = (windowHash * R + (c - 'a' + 1)) % MOD;
            right++;

            if (right - left == needle.length()) {
                if (needleHash == windowHash) {
                    if (needle.equals(haystack.substring(left, right))) {
                        return left;
                    }
                }

                char d = haystack.charAt(left);
                windowHash = (windowHash - ((d - 'a' + 1) * RL) % MOD + MOD) % MOD;
                left++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementStrStr().strStr("hello", "ll"));
        System.out.println(new ImplementStrStr().strStr("aaaaa", "bba"));
        System.out.println(new ImplementStrStr().strStr("hello", ""));
        System.out.println(new ImplementStrStr().strStr("aabaaabaaac", "aabaaac"));
        System.out.println(new ImplementStrStr().strStr("ababcaababcaabc", "ababcaabc"));
    }
}
