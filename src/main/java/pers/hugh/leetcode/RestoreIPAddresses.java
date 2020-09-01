package pers.hugh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hughding
 * @date 2020/8/31 17:14
 **/
public class RestoreIPAddresses {

//    93. Restore IP Addresses
//
//    Given RestoreIPAddresses string s containing only digits. Return all possible valid IP addresses that can be obtained from s. You can return them in any order.
//
//    A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single points and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
//
//
//
//    Example 1:
//
//    Input: s = "25525511135"
//    Output: ["255.255.11.135","255.255.111.35"]
//    Example 2:
//
//    Input: s = "0000"
//    Output: ["0.0.0.0"]
//    Example 3:
//
//    Input: s = "1111"
//    Output: ["1.1.1.1"]
//    Example 4:
//
//    Input: s = "010010"
//    Output: ["0.10.0.10","0.100.1.0"]
//    Example 5:
//
//    Input: s = "101023"
//    Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//
//    Constraints:
//
//            0 <= s.length <= 3000
//    s consists of digits only.

    //数字[0,255]且前缀不能为0
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restore(result, new ArrayList<>(), s);
        return result;
    }

    private void restore(List<String> result, List<String> split, String s) {
        if (split.size() == 4 || s.length() == 0) {
            if (split.size() == 4 && s.length() == 0) {
                String ip = String.join(".", split);
                result.add(ip);
            }
            return;
        }

        for (int i = 0; i < 3 && i < s.length(); i++) {
            //大于一位数字，且为0
            if (i > 0 && s.charAt(0) == '0') {
                break;
            }
            String item = s.substring(0, i + 1);
            //大于255
            if (Integer.valueOf(item) > 255) {
                continue;
            }
            split.add(item);
            restore(result, split, s.substring(i + 1));
            split.remove(split.size() - 1);
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses solution = new RestoreIPAddresses();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }
}
