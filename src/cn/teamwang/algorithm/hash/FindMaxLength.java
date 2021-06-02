package cn.teamwang.algorithm.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class FindMaxLength {
    public static void main(String[] args) {
        int[] nums1 = {0, 1};
        int[] nums2 = {0, 1, 0};
        int[] nums3 = {0, 0, 1, 0, 0, 0, 1, 1};
//        System.out.println(findMaxLength(nums1));
//        System.out.println(findMaxLength(nums2));
        System.out.println(findMaxLength(nums3));
    }

    /**
     * 0变-1，求最长的连续子数组，其元素和为0
     * 哈希表解题模板：
     * 1. cur
     * 2. map<res, index> 索引放后面是因为容易获取
     */
    public static int findMaxLength(int[] nums) {
        int maxLen = 0;
        // key:(pre)sum, val:索引
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
            sum += nums[i];
            if (sum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            if (sum==-2) {
                System.out.println(i);
            }
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                // 放在else防止key覆盖
                map.put(sum, i);
            }
        }
        System.out.println(Arrays.toString(nums));
        return maxLen;
    }
}
