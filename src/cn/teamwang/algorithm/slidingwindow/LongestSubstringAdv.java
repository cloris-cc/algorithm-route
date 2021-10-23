package cn.teamwang.algorithm.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 395. 至少有 K 个重复字符的最长子串
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LongestSubstringAdv {
    public static void main(String[] args) {
//        System.out.println(longestSubstring3("aaabb", 3));
//        System.out.println(longestSubstring3("ababbc", 2));
//        System.out.println(longestSubstring3("bbaaacbd", 3));
        String s1 = "aaabb";
        System.out.println(Arrays.toString(s1.split("b")));

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
        int maxLen = 0;
        int n = s.length();
        for (int t = 1; t <= 26; t++) {
            int l = 0, r = 0;
            int[] freq = new int[26];
            int tot = 0;
            int less = 0;
            while (r < n) {
                freq[s.charAt(r) - 'a']++;
                if (freq[s.charAt(r) - 'a'] == 1) {
                    tot++;
                    less++;
                }
                if (freq[s.charAt(r) - 'a'] == k) {
                    less--;
                }

                while (tot > t) {
                    freq[s.charAt(l) - 'a']--;
                    if (freq[s.charAt(l) - 'a'] == k - 1) {
                        less++;
                    }
                    if (freq[s.charAt(l) - 'a'] == 0) {
                        tot--;
                        less--;
                    }
                    l++;
                }
                if (less == 0) {
                    maxLen = Math.max(maxLen, r - l + 1);
                }
                r++;
            }
        }
        return maxLen;
    }

    /**
     * todo: rewrite 分治算法(递归)
     */
    public static int longestSubstring3(String s, int k) {
        // 1. 递归终止条件
        if (s.length() < k) {
            return 0;
        }
        // 统计每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
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
