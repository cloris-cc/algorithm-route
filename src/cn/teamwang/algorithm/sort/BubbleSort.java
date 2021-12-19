package cn.teamwang.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序的概念：较大的数慢慢冒上来。
 * 时间复杂度：平均/最坏O(n^2) 最好O(n)
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class BubbleSort {
    public static void main(String[] args) {
        /*
         * 排序过程：
         * i=0,第一趟：[1,5] [3,5] [4,5] [2,5] to {1,3,4,2,5}，冒上来了第一(最)大值 5
         * i=1,第二趟：[1,3] [3,4] [2,4] to {1,3,2,4,5}，冒上来了第二大值 4
         * i=2,第三趟：[1,3] [2,3] [3,4] to {1,2,3,4,5}，冒上来了第三大值 3
         * i=3,第四趟：...
         */
        int[] nums = {5,1,3,4,2};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }
    }
}
