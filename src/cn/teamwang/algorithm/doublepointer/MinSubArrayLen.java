package cn.teamwang.algorithm.doublepointer;

/**
 * 209. 长度最小的子数组
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 4, 4};
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] nums4 = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
        System.out.println(minSubArrayLen1(7, nums1));
        System.out.println(minSubArrayLen1(4, nums2));
        System.out.println(minSubArrayLen1(11, nums3));
        System.out.println(minSubArrayLen1(213, nums4));
        System.out.println();
        System.out.println(minSubArrayLen2(7, nums1));
        System.out.println(minSubArrayLen2(4, nums2));
        System.out.println(minSubArrayLen2(11, nums3));
        System.out.println(minSubArrayLen2(213, nums4));

    }

    /**
     * 不能少了最亲切的穷举法，时间复杂度O(n^2)
     * 子串和 >= target
     */
    public static int minSubArrayLen1(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= target) {
                minLen = Math.min(minLen, 1);
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    /**
     * 该题无需排序！！双指针([滑动窗口]/二分查找) O(n)
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int sum = 0;

        while (l < nums.length && r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                // 满足条件了，l滑动
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l];
                l++;
            }
            // sum < target
            r++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
