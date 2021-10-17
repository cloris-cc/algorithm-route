package cn.teamwang.algorithm.hash.medium;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 4, 4};
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};

        System.out.println(minSubArrayLen(7, nums1));
        System.out.println(minSubArrayLen(4, nums2));
        System.out.println(minSubArrayLen(11, nums3));
        System.out.println(minSubArrayLen1(7, nums1));
        System.out.println(minSubArrayLen1(4, nums2));
        System.out.println(minSubArrayLen1(11, nums3));


    }

    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static int minSubArrayLen1(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int sum = 0;

        while (l < nums.length && r < nums.length) {
            // 超标l滑，否则右滑
            sum += nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
