package cn.teamwang.algorithm.daily.leetcode;

/**
 * 26. 删除有序数组中的重复项
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

//        System.out.println(removeDuplicates(nums1));
        System.out.println(removeDuplicates(nums2));
    }

    public static int removeDuplicates(int[] nums) {
        // 有序，双指针
        int l = 1, r = 1;
        while (r < nums.length) {
            if (nums[r] != nums[r - 1]) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}
