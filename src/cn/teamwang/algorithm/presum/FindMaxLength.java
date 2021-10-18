package cn.teamwang.algorithm.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class FindMaxLength {
    public static void main(String[] args) {
        int[] nums1 = {0, 1};
        int[] nums2 = {0, 1, 0};
        int[] nums3 = {0, 1, 0, 1};
        System.out.println(findMaxLength(nums1));
        System.out.println(findMaxLength(nums2));
        System.out.println(findMaxLength(nums3));
    }

    public static int findMaxLength(int[] nums) {
        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            // 想象两条长度不同的横线
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

}