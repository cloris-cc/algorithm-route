package cn.teamwang.algorithm.dp.medium;

/**
 * todo 198. 打家劫舍
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(rob2(nums1));
        System.out.println(rob2(nums2));
    }

    /**
     * [5,2,3,100,1]
     * 5+100
     * <p>
     * todo 也试一下
     * Error（因为无法得出res）: dp[i] 表示偷到第i个房子时的最高金额。
     * dp[0] = nums[0]
     * dp[i] = max(dp[i-2] || dp[i-3] + nums[i]
     * j<i-1(不能相邻)
     * <p>
     * Correct: dp[i] 表示前i间房子能偷到的最高金额。
     * dp[0] = n[0], dp[1] = max(n[0], n[1])
     * dp[i] = max(dp[i-1], dp[i-2]+n[i])
     */
    public static int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
