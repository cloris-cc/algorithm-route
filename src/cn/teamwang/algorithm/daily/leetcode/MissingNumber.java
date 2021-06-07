package cn.teamwang.algorithm.daily.leetcode;

/**
 * 面试题 17.04. 消失的数字
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber1(nums1));
        System.out.println(missingNumber1(nums2));
        System.out.println(missingNumber2(nums1));
        System.out.println(missingNumber2(nums2));
    }

    public static int missingNumber1(int[] nums) {
        // 数学公式,初始值 n(n+1)/2
        int[] freq = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;

        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
