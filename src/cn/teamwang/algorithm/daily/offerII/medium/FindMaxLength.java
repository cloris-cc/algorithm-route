package cn.teamwang.algorithm.daily.offerII.medium;

import java.util.HashMap;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class FindMaxLength {
    public static void main(String[] args) {
        int[] nums1 = {0, 1};
        int[] nums2 = {0, 1, 0};
        System.out.println(findMaxLength(nums1));
        System.out.println(findMaxLength(nums2));
    }

    public static int findMaxLength(int[] nums) {
        int maxLen = 0;
        int sum = 0;
        // 使用map来存放前后缀的好处是：不需要考虑长度/空间大小。
        HashMap<Integer, Integer> map = new HashMap<>();

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
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
