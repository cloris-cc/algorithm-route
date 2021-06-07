package cn.teamwang.algorithm.dp.medium;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5};
        System.out.println(coinChange(coins1, 11));
    }

    /**
     * 最优解又是动态规划了。
     * dp[i] 表示  凑成金额i的最少硬币个数。
     * dp[i] = min(dp[i-coins[x]]) + 1
     * = min(dp[i], dp[i-coins[x] + 1)
     * 注意：因为方程内用到了dp[i]自己，所以要有合理初始值。
     * dp[0] = 0
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 求min，所以填充最大值。合理的最大值为amount(当有且使用硬币面值1)
        // 这里的amount+1是不可能取得的最大值，+1 +2..都一样。
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
