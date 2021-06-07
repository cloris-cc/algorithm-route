package cn.teamwang.algorithm.dp;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * dp[i] 表示 以第i个数结尾的 子数组最大和。 i <= num.length
     * dp[0] = nums[0]
     * dp[i] = max(dp[i-1] + nums[i], nums[i])。
     * 考虑到状态转移方程只和i-1(即上一行)有关，故可以省略。
     */
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
/*
        int max = nums[0], sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 前者(子序列的和)大就保留前者，后者大就说明前面连续数字加起来都不如后者一个新进来的数字大，前面数字就可以舍弃
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
*/
    }
}
