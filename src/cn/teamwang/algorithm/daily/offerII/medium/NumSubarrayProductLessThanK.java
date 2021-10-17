package cn.teamwang.algorithm.daily.offerII.medium;

/**
 * todo review
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums1 = {10, 5, 2, 6};
        int[] nums2 = {1, 2, 3};
        System.out.println(numSubarrayProductLessThanK(nums1, 100));
        System.out.println(numSubarrayProductLessThanK(nums2, 0));
        System.out.println(numSubarrayProductLessThanK1(nums1, 100));
        System.out.println(numSubarrayProductLessThanK1(nums2, 0));
    }

    /**
     * 穷举法
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int mul = 1;
            for (int j = i; j < nums.length; j++) {
                mul *= nums[j];
                if (mul < k) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static int numSubarrayProductLessThanK1(int[] nums, int k) {
        int res = 0;
        int l = 0, r = 0;
        int mul = 1;

        while (l < nums.length && r < nums.length) {
            // 大于等于k移动L，小于k移动r
            mul *= nums[r];
            while (l <= r && mul >= k) {
                mul /= nums[l];
                l++;
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }
}
