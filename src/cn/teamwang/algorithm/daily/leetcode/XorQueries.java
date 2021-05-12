package cn.teamwang.algorithm.daily.leetcode;

import java.util.Arrays;

/**
 * 1310. 子数组异或查询
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class XorQueries {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 8};
        int[][] queries1 = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        int[] arr2 = {4, 8, 2, 10};
        int[][] queries2 = {{2, 3}, {1, 3}, {0, 0}, {0, 3}};
        int[] arr3 = {16};
        int[][] queries3 = {{0, 0}, {0, 0}, {0, 0}};
        System.out.println(Arrays.toString(xorQueries1(arr1, queries1)));
        System.out.println(Arrays.toString(xorQueries2(arr1, queries1)));
        System.out.println(Arrays.toString(xorQueries1(arr2, queries2)));
        System.out.println(Arrays.toString(xorQueries2(arr2, queries2)));
        System.out.println(Arrays.toString(xorQueries1(arr3, queries3)));
        System.out.println(Arrays.toString(xorQueries2(arr3, queries3)));
    }

    /**
     * 暴力解法：时间复杂度O(n^2)
     */
    public static int[] xorQueries1(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];

        // 遍历queries每一行，并计算xor值
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                res[i] ^= arr[j];
            }
        }
        return res;
    }

    /**
     * 前缀异或：时间复杂度O(n)
     */
    public static int[] xorQueries2(int[] arr, int[][] queries) {
        // a0 a1 a2 a3
        // 保存运算结果：t0=a0, t1=t0^a1, t2=t1^a2, t3=t2^a3
        // 求1-3：即t3^t0 求2-3:即t3^t1
        int[] res = new int[queries.length];
        int[] t = new int[arr.length];
        t[0] = arr[0];

        for (int i = 1; arr.length > 1 && i < t.length; i++) {
            t[i] = t[i - 1] ^ arr[i];
        }
        // 遍历queries每一行，并计算xor值
        for (int i = 0; i < queries.length; i++) {
            // queries[i][0] to queries[i][1]
            if (queries[i][0] == 0) {
                res[i] = t[queries[i][1]];
            } else {
                res[i] = t[queries[i][0] - 1] ^ t[queries[i][1]];
            }
        }
        return res;
    }

    /**
     * 优化 xorQueries2 代码结构
     */
    public static int[] xorQueries3(int[] arr, int[][] queries) {
        // a0 a1 a2 a3
        // 保存运算结果：t0=0, t1=t0^a0, t2=t1^a1, t3=t2^a2, t4=t3^a3
        // 求1-3：即t4^t1 求2-3:即t4^t2
        int[] res = new int[queries.length];
        int[] t = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            t[i + 1] = t[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = t[queries[i][0]] ^ t[queries[i][1] + 1];
        }
        return res;
    }
}
