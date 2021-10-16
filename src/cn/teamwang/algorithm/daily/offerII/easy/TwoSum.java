package cn.teamwang.algorithm.daily.offerII.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 4, 6, 10};
        int[] numbers2 = {2, 3, 4};
        int[] numbers3 = {-1, 0};
        System.out.println(Arrays.toString(twoSum(numbers1, 8)));
        System.out.println(Arrays.toString(twoSum(numbers2, 6)));
        System.out.println(Arrays.toString(twoSum(numbers3, -1)));
    }

    /**
     * 暴力解法 O(n^2)
     */
    public static int[] twoSum(int[] numbers, int target) {
        // key:tar, val:index
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int t = target - numbers[i];
            if (cnt.containsKey(t)) {
                return new int[]{cnt.get(t), i};
            }
            cnt.put(numbers[i], i);
        }
        return new int[]{};
    }
}
