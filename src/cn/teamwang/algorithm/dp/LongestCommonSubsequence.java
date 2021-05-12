package cn.teamwang.algorithm.dp;

/**
 * 1143. 最长公共子序列
 * <p>
 * 题解：https://leetcode-cn.com/problems/longest-common-subsequence/solution/zui-chang-gong-gong-zi-xu-lie-by-leetcod-y7u0/
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));

    }

    /**
     * dp[i][j]表示 text1[0:i]和text2[0:j] 的最长公共子序列的长度(res)。
     * <p>
     * dp[0][j],dp[i][0]说明有空串，故res均为0。
     * 对于 i-1,j-1 ==> text1[i-1], text2[j-1] 而言：
     * 1. 当 text1[i-1]=text2[j-1] 时，dp[i][j] = dp[i-1][j-1] + 1
     * 2. 当 text1[i-1]!=text2[j-1] 时, dp[i][j] = max(dp[i][j-1], dp[i-1][j])
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 注意边界
        for (int i = 1; i <= m; i++) {
            // text1[i-1]
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                // text2[j-1]
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
