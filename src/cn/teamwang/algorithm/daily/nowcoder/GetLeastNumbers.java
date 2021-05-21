package cn.teamwang.algorithm.daily.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution2(nums, 4));
        System.out.println(Arrays.toString(nums));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        if (k > input.length) {
            return res;
        }
        for (int j : input) {
            list.add(j);
        }
        Collections.sort(list);
        for (int i = 0; i < k; i++) {
            res.add(list.get(i));
        }
        return res;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        if (k > input.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>(k);
        // 快速排序
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int base = nums[left];
        int i = left, j = right;

        while (i < j) {
            // 右 小
            while (i < j && nums[j] > base) {
                j--;
            }
            // 左 大
            while (i < j && nums[i] < base) {
                i++;
            }
            // 交换
            if (nums[i] == nums[j]) {
                i++;
            } else {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        // 重复
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
}
