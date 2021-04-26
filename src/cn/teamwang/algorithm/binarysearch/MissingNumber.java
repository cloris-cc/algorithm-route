package cn.teamwang.algorithm.binarysearch;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        int[] nums2 = {0};
        int[] nums3 = {0, 1};
        int[] nums4 = {0, 1, 2, 3, 4, 5, 6, 7, 9};

//        System.out.println(missingNumber2(nums1)); // 8
//        System.out.println(missingNumber2(nums2)); // 1
//        System.out.println(missingNumber2(nums3)); // 2

        System.out.println(missingNumber1(nums4));
    }

    public static int missingNumber1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2; // mid:4 num[mid]:5  [0,1,2,3,4,5,6,7,9] len:9 output:8
            if (nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return l;

    }

    public static int missingNumber2(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }
}
