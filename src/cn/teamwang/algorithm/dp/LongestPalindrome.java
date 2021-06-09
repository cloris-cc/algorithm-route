package cn.teamwang.algorithm.dp;

/**
 * 5. todo star 最长回文子串
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome1("aaaa"));
        System.out.println(longestPalindrome2("aaaa"));
    }

    /**
     * 暴力解法O(n^3)：枚举所有子串，并判断是否为回文串。
     */
    public static String longestPalindrome1(String s) {
        String res = String.valueOf(s.charAt(0));

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                // substring 不包括边界下标 j
                String sub = s.substring(i, j);
                if (check(sub)) {
                    // 是回文串
                    res = sub.length() > res.length() ? sub : res;
                }
            }
        }
        return res;
    }

    private static boolean check(String sub) {
        for (int i = 0; i < sub.length() / 2; i++) {
            if (sub.charAt(i) != sub.charAt(sub.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * dp[i][j] 表示 s[i:j] 是否是回文串。i<=j
     * 初始值：i=j
     * 状态转移方程：dp[i][j]=dp[i+1][j-1] & s.chatAt(i)==s.charAt(j)
     * abcba
     * 出现了i+1，所以按顺序正常循环是不知道dp[i+1]的结果的。该题可以把j作为第一层循环，就可以知道dp[i+1][j-1]中j-1的i+1了
     */
    public static String longestPalindrome2(String s) {
        int len = s.length(), maxLen = 1, begin = 0;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] == chars[j]) {
                    // j3-i1=2 < 3, 如aba；  j2-i1=1 < 3, 如aa
                    dp[i][j] = (j - i) < 3 ? true : dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > maxLen) { // 是回文串
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        // [0,3]
        return s.substring(begin, begin + maxLen);
    }
}
