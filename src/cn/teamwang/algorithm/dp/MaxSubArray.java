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
     * 为什么用动态规划？
     */
    public static int maxSubArray(int[] nums) {
/*        int len = nums.length;
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < len; i++) {
            // 前者(子序列的和)大就保留前者，后者大就说明前面连续数字加起来都不如后者一个新进来的数字大，前面数字就可以舍弃
            sum = Math.max(sum + nums[i], nums[i]);
            if (sum >= max) {
                max = sum;
            }
        }
        return max;*/
        int max = nums[0], sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
