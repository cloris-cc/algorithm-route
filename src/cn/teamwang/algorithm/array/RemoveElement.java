package cn.teamwang.algorithm.array;

import com.sun.tools.javac.util.Assert;

import java.util.Arrays;

/**
 * 27. 移除元素
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3};
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums1, 3));
        System.out.println(removeElement(nums2, 2));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len] = nums[i];
                len++;
            }
        }
        int[][] matrix = new int[5][5];
        Arrays.toString(matrix);
        return len;
    }
}
