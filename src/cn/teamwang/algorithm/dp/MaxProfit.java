package cn.teamwang.algorithm.dp;

/**
 * 剑指 Offer 63. 股票的最大利润
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] nums1 = {7, 1, 5, 3, 6, 4};
        int[] nums2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit1(nums1));
        System.out.println(maxProfit1(nums2));
    }

    /**
     * O(n^2)
     */
    public static int maxProfit1(int[] prices) {
        int index = 0;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                    index = j;
                }
            }
        }

        if (index == 0) {
            return 0;
        } else {
            return maxProfit;
        }
    }

    /**
     * 动态规划O(n)
     * 1. 状态定义：设动态列表dp，dp[i]为最大利润 (即以prices[i]结尾的子数组的最大差值)
     * 2. 状态转移方程：最大利润dp[i]等于前i-1日中的最大利润dp[i-1]和第i日卖出的最大利润中的最大值。
     * <p>
     * dp[i] = max(dp[i-1], prices[i]-min(prices[0:i]))
     * 优化后：profit = max(profit, prices[i] - min(cost, prices[i]))
     */
    public static int maxProfit2(int[] prices) {
        int profit = 0, cost = Integer.MAX_VALUE;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
