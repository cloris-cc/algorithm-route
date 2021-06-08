package cn.teamwang.algorithm.dp.medium;

import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和 todo review
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MinimumTotal {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = Arrays.asList(6, 5, 7);
        List<Integer> list4 = Arrays.asList(4, 1, 8, 3);
        List<List<Integer>> test1 = Arrays.asList(list1, list2, list3, list4);
        List<List<Integer>> test2 = Arrays.asList(Arrays.asList(-10));
//        System.out.println(minimumTotal(test1));
//        System.out.println(minimumTotal(test2));
        // [[7],[-5,9],[6,5,2],[-8,-2,-7,3],[-2,6,-6,-1,4]] 预期-6 输出-2
        System.out.println(minimumTotal(Arrays.asList(
                Arrays.asList(7),
                Arrays.asList(-5, 9),
                Arrays.asList(6, 5, 2),
                Arrays.asList(-8, -2, -7, 3),
                Arrays.asList(-2, 6, -6, -1, 4)
        )));
    }

    /**
     * dfs or dp先
     * dp[i][j] 表示到坐标(i,j)的 最小路径和
     * i=0,(j=0):dp[0][0]=t[0][0], i!=0,j=0:dp[i][0]=累加t[i][0],
     * dp[i][j] = min(dp[i-1][j], dp[i-1][j-1]) + t[i][j], 其中j<i
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;
        int m = triangle.size();
        int[][] dp = new int[m][m]; // 正方形了
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            // 初始化最左侧
            dp[i][0] += dp[i - 1][0] + triangle.get(i).get(0);
            // j<i, 相当于 表达式对最右侧不成立
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            // 初始化最右侧
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        // min最后一行
        for (int j = 0; j < m; j++) {
            res = Math.min(res, dp[m - 1][j]);
        }
        return res;
    }
}
