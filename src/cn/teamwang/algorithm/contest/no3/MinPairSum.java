package cn.teamwang.algorithm.contest.no3;

import java.util.Arrays;

/**
 * todo
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MinPairSum {
    public static void main(String[] args) {
        int[] nums1 = {3,5,2,3};
        int[] nums2 = {3,5,4,2,4,6};
        System.out.println(minPairSum(nums1));
        System.out.println(minPairSum(nums2));
    }

    public static int minPairSum(int[] nums) {
        int res = Integer.MIN_VALUE;
        // 2,3,3,5
        // 2,3,4,4,5,6
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            res = Math.max(res, nums[i] + nums[nums.length - 1 - i]);
        }
        return res;
    }
}
