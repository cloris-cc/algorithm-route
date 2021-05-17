package cn.teamwang.algorithm.daily.nowcoder;

/**
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 * https://www.nowcoder.com/practice/7d21b6be4c6b429bb92d219341c4f8bb?tpId=188&tqId=38278&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] m1 = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int[][] m2 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(m1));
        System.out.println(minPathSum(m2));
    }

    /**
     * 可以遍历的：row，col
     * 1. dp[i][j]表示 走到i,j时 的路径和。
     * 2. 初始状态：dp[0][0]=matrix[0][0], dp[0][1]=dp[0][0]+same, dp[1][0]=dp[0][0]+same
     * 3. 状态转移方程：dp[i][j] = 向下dp[i-1][j]+matrix[i][j] || 向右dp[i][j-1]+matrix[i][j]
     * 简化后 dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + matrix[i][j]
     */
    public static int minPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        /*
         * 初始化。因为循环内部 i,j 均不能为0
         */
        // i=0, j=0
        dp[0][0] = matrix[0][0];
        // i=0, j!=0
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }
        // i!=0, j=0
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        // 状态转移方程: dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + matrix[i][j]
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}
