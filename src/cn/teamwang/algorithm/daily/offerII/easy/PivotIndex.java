package cn.teamwang.algorithm.daily.offerII.easy;

import java.util.Arrays;

/**
 * 剑指 Offer II 012. 左右两边子数组的和相等
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class PivotIndex {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {1, 2, 3};
        System.out.println(pivotIndex1(nums1));
        System.out.println(pivotIndex1(nums2));
        System.out.println(pivotIndex(nums1));
        System.out.println(pivotIndex(nums2));
    }

    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];

        L[0] = 0;
        R[len - 1] = 0;
        for (int i = 1; i < len; i++) {
            L[i] = L[i - 1] + nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            R[i] = R[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            if (L[i] == R[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 有负数，不能用滑动窗口。
     */
    public static int pivotIndex1(int[] nums) {
        // l+nums[i]+r=total, l=r
        // nums[i]=total-2l
        int l = 0;
        int total = Arrays.stream(nums).sum();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == total - 2 * l) {
                return i;
            }
            l += nums[i];
        }
        return -1;
    }
}
