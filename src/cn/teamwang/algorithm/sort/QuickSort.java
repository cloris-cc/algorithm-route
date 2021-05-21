package cn.teamwang.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序是对冒泡排序算法的一种改进。因为有了边界值，所以减少了比较次数，不需要每次都比较左右向相邻的两个值。
 * <p>
 * 步骤一：取基准值，并将数据分成左右两部分
 * 步骤二：小于分界值的数据放数组左边，大于或等于分界值的数据放数组右边。
 * 步骤三：左、右边界重复上述过程。
 * <p>
 * 使用双指针，把小于、大于基准数base的值分成两边。
 * 先从最右位置往左j--开始找直到找到一个小于基准数的值，记录下该值的位置（记作 i）。
 * 再从最左位置往右i++找直到找到一个大于基准数的值，记录下该值的位置（记作 j）。
 * 如果位置i<j，则交换i和j两个位置上的值，然后继续从(j-1)的位置往前和(i+1)的位置往后重复上面比对基准数然后交换的步骤。
 * 如果执行到i==j，表示本次比对已经结束，将最后i的位置的值与基准数做交换，此时基准数就找到了临界点的位置k，位置k两边的数组都比当前位置k上的基准值或都更小或都更大。
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 4, 2};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int left, int right) {
        // 递归的终止条件
        if (left > right) {
            return;
        }
        int base = nums[left];
        int i = left, j = right;

        while (i < j) {
            // 从右开始找第一个小于base（忽略 i<j 条件）
            // 右 小
            while (i < j && nums[j] > base) {
                j--;
            }
            // 从左开始找第一个大于base
            // 左 大
            while (i < j && nums[i] < base) {
                i++;
            }
            // 交换位置
            if (nums[i] == nums[j]) {
                i++;
            } else {
                // nums[j] > nums[i]
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        // 左、右子数组重复上述步骤
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
}
