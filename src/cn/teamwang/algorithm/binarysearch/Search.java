package cn.teamwang.algorithm.binarysearch;

import jdk.nashorn.internal.runtime.UserAccessorProperty;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Search {
    public static void main(String[] args) {
        // nums = [5,7,7,8,8,10], target = 8
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums2 = {1};
        int[] nums3 = {2, 2};
        System.out.println(search(nums3, 2));
    }

    /**
     * 二分查找时间复杂度：
     */
    public static int search(int[] nums, int target) {

        if (nums.length == 0) {
            return 0;
        }

        int count = 0;
        int left = 0, right = nums.length - 1;
        int mid = 0;

        // 先用二分查找找到首个下标mid
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                count++;
                break;
            }
        }

        // 如果找到了，则向左向右查找
        if (count == 1) {
            int toLeft = mid - 1, toRight = mid + 1;
            while (toLeft >= 0 && nums[toLeft] == target) {
                count++;
                toLeft--;
            }
            while (toRight <= nums.length-1 && nums[toRight] == target) {
                count++;
                toRight++;
            }
        }

        return count;
    }
}
