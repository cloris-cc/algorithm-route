package cn.teamwang.algorithm.hash.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. 只出现一次的数字
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums1));
        System.out.println(singleNumber(nums2));
        System.out.println(singleNumber1(nums1));
        System.out.println(singleNumber1(nums2));
    }

    public static int singleNumber(int[] nums) {
        // key:数字，val:次数
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return -1;
    }

    /**
     * 2个相同的数异或结果为0
     */
    public static int singleNumber1(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }

}
