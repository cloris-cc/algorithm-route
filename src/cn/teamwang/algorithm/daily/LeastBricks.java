package cn.teamwang.algorithm.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 554. 砖墙
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LeastBricks {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 2, 1}, {3, 1, 2}, {1, 3, 2}, {2, 4}, {3, 1, 2}, {1, 3, 1, 1}};

    }

    /**
     * error
     */
    public int leastBricks(List<List<Integer>> wall) {
        if (wall.get(0).size() == 1) {
            return wall.size();
        }

        // 每一行砖块的宽度之和
        int line = 0;
        int min = Integer.MAX_VALUE;
        for (Integer i : wall.get(0)) {
            line += i;
        }


        for (int l = 2; l <= line; l++) {
            int bricks = 0;
            // 遍历每一行
            for (List<Integer> row : wall) {
                // 计算穿过的砖块数
                int index = 0;
                int sum = row.get(index);
                while (sum < l - 1) {
                    index++;
                    sum += row.get(index);
                }
                System.out.println("line:" + l + ", sum:" + sum);
                if (sum >= l) {
                    bricks++;
                }
            }
            min = Math.min(min, bricks);

        }
        return min;
    }
}
