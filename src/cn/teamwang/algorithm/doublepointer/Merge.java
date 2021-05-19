package cn.teamwang.algorithm.doublepointer;

import java.util.Arrays;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge2(nums1, 3, nums2, 3);
    }

    /**
     * 排序，时间复杂度O((m+n)log(m+n))
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 双指针，时间复杂度O(m+n)
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int l1 = 0, l2 = 0;
        int curVal;

        while (l1 < m || l2 < n) {
            if (l1 == m) {
                curVal = nums2[l2++];
            } else if (l2 == n) {
                curVal = nums1[l1++];
            } else if (nums1[l1] < nums2[l2]) {
                curVal = nums1[l1++];
            } else {
                curVal = nums2[l2++];
            }
            res[l1 + l2 - 1] = curVal;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }

    public static void merge3(int[] nums1, int m, int[] nums2, int n) {

    }
}
