package cn.teamwang.algorithm.daily.leetcode.medium;

import java.util.Arrays;

/**
 * 48. 旋转图像
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(matrix.length);
    }

    // matrix_new[col][n−row−1] = matrix[row][col]
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

    public static void rotate_1(int[][] matrix) {
        int row = matrix.length;
        // 水平翻转
        for (int i = 0; i < row / 2; ++i) {
            for (int j = 0; j < row; ++j) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[row - i - 1][j];
                matrix[row - i - 1][j] = t;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < i; ++j) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}
