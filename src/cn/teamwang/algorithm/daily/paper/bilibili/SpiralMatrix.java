package cn.teamwang.algorithm.daily.paper.bilibili;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class SpiralMatrix {
    public static void main(String[] args) {

    }

    public static int[] SpiralMatrix(int[][] matrix) {
        // write code here
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int i = 0;

        // 一圈：上、右、下、左
        int up_begin = 0, up_end = n - 1;
        int l_begin = n - 1, l_end = 0;
        while (i < m * n) {
            // 一圈：上、右、下、左


//            res[i] = ?;

            i++;
        }
        return new int[0];
    }
}
