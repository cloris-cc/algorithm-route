package cn.teamwang.algorithm.doublepointer;

import java.util.Arrays;

/**
 * todo 找题目
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class ReverseNums {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 3, 4, 5, 6};
        reverse2(nums1);
        reverse2(nums2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * 左右指针
     */
    public static void reverse1(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            // swap(nums[left], nums[right])
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }

    /**
     * todo 普通方法
     */
    public static void reverse2(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int t = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = t;
        }
    }
}
