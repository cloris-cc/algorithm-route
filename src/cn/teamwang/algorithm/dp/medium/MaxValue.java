package cn.teamwang.algorithm.dp.medium;

/**
 * 剑指 Offer 47. 礼物的最大价值
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MaxValue {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid2 = {{9, 1, 4, 8}};
        System.out.println(maxValue(grid1));
        System.out.println(maxValue(grid2));
    }

    /**
     * 最优解dp
     * 1. dp[i][j] 表示到坐标(i, j)时的 最大价值
     * 2. dp[0][0] = g[0][0], dp[i][0] = sum(g[i][0]), dp[0][j] = sum(g[0][j])
     * 3. dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + g[i][j]
     */
    public static int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        /*
         * 初始化。也可以多开一行new int[m+1][n+1]，跳过该步骤。返回值为dp[m][n]
         */
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
