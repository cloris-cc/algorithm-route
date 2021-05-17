package cn.teamwang.algorithm.daily.leetcode;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CountTriplets {
    public static void main(String[] args) {
//        System.out.println(3 ^ 3); // 0
//        System.out.println(3 ^ 0); // 3
        int[] test1 = {2,3,1,6,7};
        int[] test2 = {1,1,1,1,1};
        int[] test3 = {2,3};
        int[] test4 = {1,3,5,7,9};
        int[] test5 = {7,11,12,9,5,2,7,17,22};
        System.out.println(countTriplets(test1));
        System.out.println(countTriplets(test2));
        System.out.println(countTriplets(test3));
        System.out.println(countTriplets(test4));
        System.out.println(countTriplets(test5));
    }

    /**
     * a ^ b = a[i]^...^a[k] = 0, 题目转化为求子串的异或结果等于0
     */
    public static int countTriplets(int[] arr) {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            int t = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                t ^= arr[k];
                if (t == 0) {
                    // j 无所谓呐，i~k任意一个数都行
                    res += k - i;
                }
            }
        }
        return res;
    }
}
