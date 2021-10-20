package cn.teamwang.algorithm.daily.offerII.medium;

/**
 * 剑指 Offer II 016. 不含重复字符的最长子字符串
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] freq = new int[128];
        int l = 0, r = 0;

        // 出现重复则移动l，没有重复则正常移动r并计算长度。
        while (r < s.length()) {
            if (freq[s.charAt(r)] == 0) {
                freq[s.charAt(r)]++;
                res = Math.max(res, r - l + 1);
                r++;
            } else { // freq[r] == 1，即已有该字符了。
                freq[s.charAt(l)]--;
                l++;
            }
        }
        return res;
    }
}
