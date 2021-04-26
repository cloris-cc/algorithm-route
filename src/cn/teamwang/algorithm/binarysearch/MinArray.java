package cn.teamwang.algorithm.binarysearch;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MinArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(minArray(nums));
    }

    public static int minArray1(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[r] > nums[mid]) { //只要右边比中间大，那右边一定是有序数组
                r = mid;
            } else if (nums[r] < nums[mid]) {
                l = mid + 1;
            } else { //去重
                r--;
            }
        }
        return nums[l];
    }

    public static int minArray(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
