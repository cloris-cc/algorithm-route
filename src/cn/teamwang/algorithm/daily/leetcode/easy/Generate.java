package cn.teamwang.algorithm.daily.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Generate {
    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate(1));
    }

    /**
     * 设dp[i][j] 为第i行，第j列的值
     * dp[0][0]=1, dp[i][0]=1,dp[i][i]=1
     * dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];

        // 最左
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < dp[i].length; k++) {
                if (dp[i][k] != 0) {
                    list.add(dp[i][k]);
                } else {
                    break;
                }
            }
            res.add(list);
        }
        return res;
    }
}
