package bao;


import java.util.HashMap;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/12/8 22:23
 */
public class Test {
    public static void main(String[] args) {
        String s = "leetcode";
        Solution solution = new Solution();
        int i = solution.firstUniqChar(s);
        System.out.println(i);
    }
}


class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}