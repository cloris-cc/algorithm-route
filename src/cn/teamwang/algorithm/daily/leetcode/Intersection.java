package cn.teamwang.algorithm.daily.leetcode;

import java.util.*;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection_bad(nums1, nums2)));
        System.out.println(Arrays.toString(intersection_bad(nums3, nums4)));
        System.out.println();
        System.out.println(Arrays.toString(intersection1(nums1, nums2)));
        System.out.println(Arrays.toString(intersection1(nums3, nums4)));
        System.out.println();
        System.out.println(Arrays.toString(intersection2(nums1, nums2)));
        System.out.println(Arrays.toString(intersection2(nums3, nums4)));
    }

    /**
     * 二分查找短数组的左(或右)边界。
     */
    public static int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int target = nums1[0];
        int index = binarySearch_left(nums2, target);
        Set<Integer> set = new HashSet<>();

        // 可以提前停止
        for (int i = 0, j = index; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[set.size()];
        int i = 0;

        for (Integer num : set) {
            res[i++] = num;
        }
        return res;
    }

    /**
     * 哈希表 替代 穷举法
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set2.add(n);
        }
        // 遍历短的
        if (set1.size() < set2.size()) {
            for (Integer n : set1) {
                if (set2.contains(n)) {
                    set.add(n);
                }
            }
        } else {
            for (Integer n : set2) {
                if (set1.contains(n)) {
                    set.add(n);
                }
            }
        }
        int[] res = new int[set.size()];
        int i = 0;

        for (Integer num : set) {
            res[i++] = num;
        }
        return res;
    }

    private static int binarySearch_left(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                // to left
                r--;
            }
        }
        return l;
    }

    public static int[] intersection_bad(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int n1 : nums1) {
            for (int n2 : nums2) {
                if (n1 == n2) {
                    set.add(n1);
                }
            }
        }
        int[] res = new int[set.size()];
        int i = 0;

        for (Integer num : set) {
            res[i++] = num;
        }
        return res;
    }
}
