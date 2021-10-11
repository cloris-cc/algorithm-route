package cn.teamwang.algorithm.daily.leetcode.easy;

/**
 * 35. 搜索插入位置
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));
        int[] nums2 = {1};
        System.out.println(searchInsert(nums2, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
