package cn.teamwang.algorithm.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_hey("abcabcbb"));
        System.out.println(lengthOfLongestSubstring_hey("bbbbb"));
        System.out.println(lengthOfLongestSubstring_hey("pwwkew"));
    }

    public static int lengthOfLongestSubstring_old(String s) {
        int len = s.length();
        int l = 0, r = -1;
        int max = 0;
        // 字符的出现频率
        int[] freq = new int[256];

        while (l < len) {
            if (r < len - 1 && freq[s.charAt(r + 1)] == 0) {
                r++;
                freq[s.charAt(r)]++;
            } else {
                freq[s.charAt(l)]--;
                l++;
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = 0;
        Set<Character> set = new HashSet<>();

        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            len = Math.max(len, r - l + 1);
        }

        return len;
    }

    /**
     * 优化后的代码结构
     */
    public static int lengthOfLongestSubstring_hey(String s) {
        if (s.length() == 1){
            return 1;
        }
        int max = 0, l = 0, r = -1;
        int[] freq = new int[256];

        while (l < s.length() - 1 && r < s.length() - 1) {
            if (freq[s.charAt(r + 1)] == 0) {
                // 没有重复，右边界滑动窗口
                r++;
                freq[s.charAt(r)]++;
            } else {
                // 重复了，左边界滑动窗口
                freq[s.charAt(l)]--;
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
