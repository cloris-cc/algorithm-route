package cn.teamwang.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 395. 至少有 K 个重复字符的最长子串
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LongestSubstringAdv {
    public static void main(String[] args) {
        System.out.println(longestSubstring3("aaabb", 3));
        System.out.println(longestSubstring3("ababbc", 2));
        System.out.println(longestSubstring3("bbaaacbd", 3));

    }

    /**
     * ERROR: 超时
     * O(n^3)穷举所有子串，并统计每次字符出现的次数。
     */
    public static int longestSubstring1(String s, int k) {
        int maxLen = 0;

        for (int i = 0; i < s.toCharArray().length; i++) {
            for (int j = i + 1; j <= s.toCharArray().length; j++) {
                String sub = s.substring(i, j);
                if (check(sub, k)) {
                    // 每一字符出现次数都不少于 k
                    maxLen = Math.max(sub.length(), maxLen);
                }
            }
        }
        return maxLen;
    }

    private static boolean check(String sub, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : sub.toCharArray()) {
            if (map.containsKey(c)) {
                // 次数加一
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < k) {
                return false;
            }
        }
        return true;
    }

    /**
     * 想滑但是滑不出来。
     */
    public static int longestSubstring2(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }
        int maxLen = 1, l = 0, r = -1;
        int[] freq = new int[256];

        while (l < s.length() - 1 && r < s.length() - 1) {
            // 右边界滑动：次数满足条件
            if (freq[s.charAt(r + 1)] < k) {
            }
        }
        return maxLen;
    }

    /**
     * 分治算法(递归)
     */
    public static int longestSubstring3(String s, int k) {
        // 1. 递归终止条件
        if (s.length() < k) {
            return 0;
        }
        // 统计每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (map.containsKey(s.charAt(i))) {
                // 次数加一
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (char c : map.keySet()) {
            if (map.get(c) < k) {
                // 2. 该字符的次数小于k，开始[分][治]
                String[] strs = s.split(String.valueOf(c));
                int len = 0;
                for (String str : strs) {
                    len = Math.max(len, longestSubstring3(str, k));
                }
                return len;
            }
        }
        return s.length();
    }
}
