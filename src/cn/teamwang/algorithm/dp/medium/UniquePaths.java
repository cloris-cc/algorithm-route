package cn.teamwang.algorithm.dp.medium;

import java.util.Arrays;

/**
 * 62. 不同路径
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths(3, 3));
    }

    /**
     * dp[i][j] 表示到达坐标(i,j)时的路径数。
     * dp[0][0]=1?m, dp[0][j] = 1, dp[i][0] = 1
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     */
    public static int uniquePaths(int m, int n) {
        // 3x3
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
