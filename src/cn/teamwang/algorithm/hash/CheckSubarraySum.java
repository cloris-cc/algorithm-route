package cn.teamwang.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CheckSubarraySum {
    public static void main(String[] args) {
        int[] nums1 = {23, 2, 4, 6, 7};
        int[] nums2 = {23, 2, 6, 4, 7};
        int[] nums3 = {23, 2, 6, 4, 7};
        int[] nums4 = {23, 2, 4, 6, 6};
        System.out.println(checkSubarraySum(nums1, 6));
        System.out.println(checkSubarraySum(nums2, 6));
        System.out.println(checkSubarraySum(nums3, 13));
        System.out.println(checkSubarraySum(nums4, 7));
    }

    /**
     * 穷举法
     */
    public static boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    return true;
                }
            }
            if (sum < k) {
                break;
            }
        }
        return false;
    }

    /**
     * 因为 sum[0:x] = m*k + mod_x,  sum[0:y] = n*k + mod_y
     * ==> sum[x:y] = (n-m)k + mod_y - mod_x
     * ==> 当 mod_y == mod_x, y - x >= 2 时，子数组总和为k的倍数
     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        // key:mod, val:index
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) >= 2) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }
}
