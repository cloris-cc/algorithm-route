package cn.teamwang.algorithm.dp.medium;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class RobII {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 2};
        int[] nums2 = {1, 2, 3, 1};
        int[] nums3 = {0};
        int[] nums4 = {1, 2, 1, 1};
        int[] nums5 = {200, 3, 140, 20, 10};
//        System.out.println(rob(nums1));
        System.out.println(rob(nums2));
//        System.out.println(rob(nums3));
//        System.out.println(rob(nums4)); // 预期3
//        System.out.println(rob(nums5)); // 预期340
    }

    /**
     * dp[i] 表示偷前i家房子 的 最高金额
     * dp[0] = n[0], dp[1] = max(n[0], n[1])
     * dp[i] = max(dp[i-2] + n[i], dp[i-1])
     * 根据题目条件有2种情况：max(偷 0~i-1 或 1~i)
     */
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int m = nums.length;
        int[] dp1 = new int[m - 1]; //0~i-1
        int[] dp2 = new int[m]; //1~i

        /*
         * for dp1
         */
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < m - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }
        /*
         * for dp2
         *
         */
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < m; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }
        return Math.max(dp1[m - 2], dp2[m - 1]);
    }
}
