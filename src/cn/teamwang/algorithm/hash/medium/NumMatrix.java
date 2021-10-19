package cn.teamwang.algorithm.hash.medium;

/**
 * 剑指 Offer II 013. 二维子矩阵的和
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class NumMatrix {
    int[][] sums;

    /**
     * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
     * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
     * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
     * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
     * <p>
     * 多次调用sumRegion更为耗时。
     */
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sums = new int[m][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 为了方便取j-1,故使用n+1。第一列不用。
                sums[i][j + 1] = sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            // +1 才是 col2（因为sums的第一列不用）
            res += sums[i][col2 + 1] - sums[i][col1];
        }
        return res;
    }
}
