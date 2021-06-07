package cn.teamwang.algorithm.dp.medium;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(lengthOfLIS(nums1));
        System.out.println(lengthOfLIS(nums2));
        System.out.println(lengthOfLIS(nums3));
    }

    /**
     * dp[i] 为以第i个数结尾的 最长递增子序列长度。 i<=nums.len
     * dp[0]=1, dp[1]=
     * dp[i] = max(dp[j]) + 1 = max(dp[j] + 1), j<i, nums[j]<nums[i]
     */
    public static int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        // 会发生覆盖(更新)，所以赋初始值
        Arrays.fill(dp, 1);
        // dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
