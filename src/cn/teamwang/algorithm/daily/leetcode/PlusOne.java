package cn.teamwang.algorithm.daily.leetcode;

import java.util.Arrays;

/**
 * 66. 加一
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        int[] test2 = {4, 3, 2, 1};
        int[] test3 = {0};
        int[] test4 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] test5 = {9, 9, 8};
        int[] test6 = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(test1)));
        System.out.println(Arrays.toString(plusOne(test2)));
        System.out.println(Arrays.toString(plusOne(test3)));
        System.out.println(Arrays.toString(plusOne(test4)));
        System.out.println(Arrays.toString(plusOne(test5)));
        System.out.println(Arrays.toString(plusOne(test6)));
    }

    /**
     * 转化为整数
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int t = digits[i] + 1;
            if (t <= 9) {
                digits[i]++;
                return digits;
            } else {
                // 进一位，遍历整个数组
                digits[i] = 0;
                if (i == 0) {
                    int[] res = new int[digits.length + 1];
                    res[i] = 1;
                    return res;
                }
            }
        }
        return new int[0];
    }
}
