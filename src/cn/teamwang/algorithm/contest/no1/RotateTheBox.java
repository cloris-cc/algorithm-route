package cn.teamwang.algorithm.contest.no1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class RotateTheBox {
    public static void main(String[] args) {
        char[][] box = {{'#', '.', '*', '.'}, {'#', '#', '*', '.'}};
        char[][] box2 = {{'#', '#', '*', '.', '*', '.'}, {'#', '#', '#', '*', '.', '.'}, {'#', '#', '#', '.', '#', '.'}};
        System.out.println(Arrays.deepToString(rotateTheBox(box2)));
//        System.out.println(Arrays.deepToString(rotateTheBox(box)));
    }

    /**
     * 用一个队列来保存空位"."
     * 当队列不为空说明可以替换为石头"#"。遇到障碍物"*"原队列不可用。
     */
    public static char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] res = new char[n][m];

        for (int i = 0; i < m; i++) {
            Deque<Integer> deque = new LinkedList<>();

            // 由右到左，处理每一行
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    // 发现障碍物
                    deque.clear();
                } else if (box[i][j] == '#') {
                    // 发现石头
                    if (!deque.isEmpty()) {
                        // pop最新(大)的j
                        int pos = deque.pollLast();
                        // 空位变石头，石头变空位
                        box[i][pos] = '#';
                        box[i][j] = '.';
                        deque.push(j);
                    }
                } else {
                    // 发现空位"."
                    deque.push(j);
                }
            }
        }

        // 旋转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // m=3, n=6
                res[j][m - 1 - i] = box[i][j];
            }
        }
        return res;
    }

}
