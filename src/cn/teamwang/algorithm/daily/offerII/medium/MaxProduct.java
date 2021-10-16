package cn.teamwang.algorithm.daily.offerII.medium;

import java.util.Arrays;

/**
 * todo review
 * 剑指 Offer II 005. 单词长度的最大乘积
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MaxProduct {
    public static void main(String[] args) {
        String[] words1 = {"abcw", "baz", "foo", "bar", "fxyz", "abcdef"};
        String[] words2 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        String[] words3 = {"a", "aa", "aaa", "aaaa"};
        System.out.println(maxProduct(words1));
        System.out.println(maxProduct(words2));
        System.out.println(maxProduct(words3));
        System.out.println(maxProduct1(words1));
        System.out.println(maxProduct1(words2));
        System.out.println(maxProduct1(words3));
    }

    /**
     * 动态规划doc.
     */
    public static int maxProduct(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (check(words[i], words[j])) { // true: 条件成立，它们不包含相同字符。
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    private static boolean check(String w1, String w2) {
        int[] freq = new int[128];
        for (int i = 0; i < w1.length(); i++) {
            freq[w1.charAt(i)] = 1;
        }
        for (int i = 0; i < w2.length(); i++) {
            if (freq[w2.charAt(i)] == 1) {
                return false;
            }
        }
        return true;
        // freq 全部为1/0返回true，>1返回false
    }

    /**
     * 26个字母用1/0数字组成的数组替代，再使用二进制位与运算(&)
     */
    public static int maxProduct1(String[] words) {
        int res = 0;
        int[] nums = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                nums[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length; j++) {
                // 如果两个字符串不包含相同元素 那么与运算肯定为 0
                if ((nums[i] & nums[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
