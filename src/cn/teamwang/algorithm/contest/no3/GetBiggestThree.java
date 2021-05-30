package cn.teamwang.algorithm.contest.no3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class GetBiggestThree {
    public static void main(String[] args) {

    }

    /**
     * 1. 设dp[i][j] 所有宽i 高j菱形 的 最大菱形和。i，j均为偶数 i==j
     * dp[0][0]=max(grid[m][n])
     * dp[1][1]=无
     * dp[i][j] = max(dp[i][j], dp[i-2][j-2]+grid[]
     */
    public static int[] getBiggestThree(int[][] grid) {
        // 暴力解法
        List<Integer> list = new ArrayList<>();
        for (int[] ints : grid) {
            for (int i : ints) {
                list.add(i);
            }
        }
        for (int w = 3; w <= 100; w += 2) {
            int max = 0;
            int sum = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    for (int t = 0; t <= w/2; t++) {
//                        sum += grid[i]
                    }
                }
            }
            max = Math.max(max, sum);
        }

        return null;
    }
}
