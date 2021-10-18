package cn.teamwang.algorithm.presum;

import java.util.HashMap;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class SubarraySum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum1(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum1(new int[]{1, 2, 3}, 3));
    }

    /**
     * 枚举
     */
    public static int subarraySum(int[] nums, int k) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * pre-sum
     */
    public static int subarraySum1(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        // key:sum val:times
        HashMap<Integer, Integer> map = new HashMap<>();
        // for condition: nums.len = 1 and nums[0] = k
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
