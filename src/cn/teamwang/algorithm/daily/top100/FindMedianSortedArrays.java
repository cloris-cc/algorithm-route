package cn.teamwang.algorithm.daily.top100;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int[] arr = new int[m + n];
        int cnt = 0, i = 0, j = 0;
        while (cnt != (m + n)) {
            if (i == m) {
                while (j != n) {
                    arr[cnt++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    arr[cnt++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                arr[cnt++] = nums1[i++];
            } else {
                arr[cnt++] = nums2[j++];
            }
        }

        if (cnt % 2 == 1) {
            return arr[cnt / 2];
        } else {
            return (arr[cnt / 2 - 1] + arr[cnt / 2]) / 2.0;
        }
    }

}
