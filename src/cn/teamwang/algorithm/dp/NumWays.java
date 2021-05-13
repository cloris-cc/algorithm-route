package cn.teamwang.algorithm.dp;

/**
 * 1269. 停在原地的方案数
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class NumWays {
    public static void main(String[] args) {
        System.out.println(numWays_ow(3, 2));
        System.out.println(numWays_ow(2, 4));
        System.out.println(numWays_ow(4, 2));
        System.out.println(numWays_ow(27, 7));
    }

    /*
     * 动态规划总结：
     * 1. 有几个可变参数决定你维护的dp数组是几维数组，dp[i][j]为结果，i和j是可以题目中可以遍历的东西。
     * 2. 求初始值
     * 3. 再求状态转移方程(从i-1或j-1或i+1或j+1入手)
     */

    /*
     * dp 和 数学归纳法？
     * 1. dp[i][j] 为 在执行i步操作后，数组下标位于j 的方案数。
     * 2. 初始值：i=0时，j=0，因此dp[0][0]=1???。没有任何操作，即无任何方案，即dp[0][j]=0
     * 3. i-1为上一步操作，j-1表示向左走，j+1表示向右，j表示停留
     * 所以状态转移方程 dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1]
     */

    /**
     * 状态转移方程：dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1]
     * 初始状态：dp[0][0] = 1, dp[0][j] = 0(其中j!=0), dp[i][0] = res
     */
    public static int numWays_ow(int steps, int arrLen) {
        // 能到达的最远下标
        int far = Math.min(steps, arrLen - 1);
        int mod = 1000000007;
        int[][] dp = new int[steps + 1][far + 1]; // 默认初始值都是0呀
        dp[0][0] = 1;

        for (int i = 1; i <= steps; i++) { // 考虑i，j范围
            for (int j = 0; j <= far; j++) {
                dp[i][j] = dp[i - 1][j];
                // 防止越界
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
                if (j + 1 <= far) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        return dp[steps][0];
    }
}
