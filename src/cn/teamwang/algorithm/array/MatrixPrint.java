package cn.teamwang.algorithm.array;

import java.util.Arrays;

/**
 * 时间复杂度 O(n) 打印二维数组
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MatrixPrint {
    public static void main(String[] args) {
        // 5行 * 3列
        int[][] matrix = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}
        };
        int m = matrix.length;
        int n = matrix[0].length;

        for (int t = 0, i = 0, j = 0; t < m * n; t++) {
            if (j < n) {
                System.out.println(matrix[i][j]);
                j++;
            } else {
                i++;
                j = 0;
            }
        }


    }


}
