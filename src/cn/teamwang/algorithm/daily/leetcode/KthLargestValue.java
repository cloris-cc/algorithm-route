package cn.teamwang.algorithm.daily.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1738. 找出第 K 大的异或坐标值
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class KthLargestValue {
    public static void main(String[] args) {
        int[][] m1 = {{5, 2}, {1, 6}};
        System.out.println(kthLargestValue1(m1, 1));
        System.out.println(kthLargestValue1(m1, 2));
        System.out.println();
        System.out.println(kthLargestValue2(m1, 1));
        System.out.println(kthLargestValue2(m1, 2));
        System.out.println();
        System.out.println(kthLargestValue2_optimized(m1, 1));
        System.out.println(kthLargestValue2_optimized(m1, 2));

    }

    public static int kthLargestValue1(int[][] matrix, int k) {
        // 2x3 = 6 dp[5]=2+3
        /* 2x3=0=6 dp[6]
        计算小矩阵
        x x x x
        x x x x
        x dp9 x dp11

        dp9 & a=2,b=1

         */
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[m * n];

        for (int a = 0; a < matrix.length; a++) {
            for (int b = 0; b < matrix[0].length; b++) {
                // 计算小矩阵异或值
                dp[a * n + b] = 0;
                for (int i = 0; i <= a; i++) {
                    for (int j = 0; j <= b; j++) {
                        dp[a * n + b] ^= matrix[i][j];
                    }
                }
            }
        }
        Arrays.sort(dp);
        return dp[dp.length - k];
    }

    /**
     * (二维)前缀和。类似动态规划。
     * 小矩阵异或：dp[i][j]=dp[i-1][j]^dp[i][j-1]^dp[i-1][j-1]^matrix[i][j]
     */
    public static int kthLargestValue2(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        /*
         * 初始化
         */
        // i=0,j=0;
        dp[0][0] = matrix[0][0];
        list.add(dp[0][0]);
        // i=0,j!=0;
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] ^ matrix[0][j];
            list.add(dp[0][j]);
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] ^ matrix[i][0];
            list.add(dp[i][0]);
        }
        // i!=0,j=0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i][j];
                list.add(dp[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(list.size() - k);
    }

    /**
     * 动态规划的代码简化（下标越界&初始化问题）
     * 时间复杂度:O(mnlog(mn))，因为O(mn)小于排序算法的O(mnlog(mn))
     */
    public static int kthLargestValue2_optimized(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1]; // 防止越界+1

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i][j];
                // 当i=0或j=0时，dp会越界。因此可以使用m+1*n+1的dp矩阵，首行首列默认0就好了。
                // 另外注意，由于要保证循环次数不变，所以i<=m,j<=n多了个等于条件，并且dp方程的matrix下标要还原，即-1。
                dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                list.add(dp[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(list.size() - k);
    }
}
