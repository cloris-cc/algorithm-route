package cn.teamwang.algorithm.dp;

/**
 * todo 剑指 Offer 47. 礼物的最大价值
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MaxValue {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(maxValue(grid));
    }

    public static int maxValue(int[][] grid) {
        int max = 0, sum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum = Math.max(sum+grid[i][j], grid[i][j]);
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
