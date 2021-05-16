package cn.teamwang.algorithm.contest.no1;

import java.util.Arrays;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class SumOfFlooredPairs {
    public static void main(String[] args) {
        int[] nums1 = {2, 5, 9}; // 7
        int[] nums2 = {7, 7, 7, 7, 7, 7, 7}; // 7*3
        int[] n3 = {4, 3, 4, 3, 5}; // 2*1
        System.out.println(sumOfFlooredPairs1(nums1));
        System.out.println(sumOfFlooredPairs1(nums2));
        System.out.println(sumOfFlooredPairs1(n3));
        System.out.println();
        System.out.println(sumOfFlooredPairs2(nums1));
        System.out.println(sumOfFlooredPairs2(nums2));
        System.out.println(sumOfFlooredPairs2(n3));
        System.out.println();
        System.out.println(sumOfFlooredPairs3(nums1));
        System.out.println(sumOfFlooredPairs3(nums2));
        System.out.println(sumOfFlooredPairs3(n3));


    }

    /**
     * 暴力求解 On^2
     */
    public static int sumOfFlooredPairs1(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    res += 1;
                } else if (nums[i] < nums[j]) {
                    res += 0;
                } else {
                    res += nums[i] / nums[j];
                }
            }
        }
        return res;
    }

    /**
     * 只有大对小有效，所以先排序
     */
    public static int sumOfFlooredPairs2(int[] nums) {
        int mod = 1000000007;
        int res = nums.length;
        Arrays.sort(nums); // nlogn

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res = (res + nums[j] / nums[i]) % mod;
                if (nums[j] == nums[i]) {
                    res = (res + 1) % mod;
                }
            }
        }
        return res;
    }

    /**
     * 二分查找，之后再看
     */
    public static int sumOfFlooredPairs3(int[] nums) {
        int mod = 1000000007;
        int res = 0; // 有mod需要为long类型吗：看具体结果
        int len = nums.length;

        Arrays.sort(nums);
        for (int num : nums) {
            // [2,5,9]
            // 对于每个num而言，从1倍开始算，第一倍+1(*满足条件的个数)，第二倍再继续+1*个数，第三倍也继续+1*个数...
            int i = 1;
            while (num * i <= nums[len - 1]) {
                int index = binarySearch_left(nums, num * i);
                res += len - index;
                res %= mod;
                i++;
            }
        }
        return res;
    }

    private static int binarySearch_left(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                // to left
                r--;
            }
        }
        return l;
    }
}
