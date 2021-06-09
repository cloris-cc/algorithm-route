package cn.teamwang.algorithm.dp.medium;

/**
 * 面试题 08.11. 硬币
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class WaysToChange {
    public static void main(String[] args) {

    }

    /**
     * 可能又是最优解了(最大值)
     * dp[i][j]表示 使用前i种面值的硬币构成金额j的 方案数
     * dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]]
     * 化简：dp[j] = dp[j] + dp[j-coins[i]]
     */
    public static int waysToChange1(int n) {
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];

        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}
