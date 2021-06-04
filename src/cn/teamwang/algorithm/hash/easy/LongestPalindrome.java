package cn.teamwang.algorithm.hash.easy;

/**
 * 409. 最长回文串
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("bb"));
    }

    public static int longestPalindrome(String s) {
        int res = 0;
        boolean flag = false;
        int[] freq = new int[128];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        for (int f : freq) {
            if (f == 1) {
                flag = true;
            }
            if (f > 1) {
                if (f % 2 == 0) {
                    res += f;
                } else {
                    res += f - 1;
                    flag = true;
                }
            }

        }

        if (flag) {
            res++;
        }
        // 全部相同 eg. bb


        return res;
    }
}
