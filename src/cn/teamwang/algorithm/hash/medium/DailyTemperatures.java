package cn.teamwang.algorithm.hash.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * todo 739. 每日温度
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class DailyTemperatures {
    public static void main(String[] args) {

    }

    /**
     * 判别是否需要使用单调栈:
     * 如果需要找到左边或者右边第一个比当前位置的数大或者小，则可以考虑使用单调栈；单调栈的题目如矩形米面积等等
     * https://leetcode-cn.com/problems/trapping-rain-water/
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
     *
     * 对于temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
     * 你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。
     *
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> s = new LinkedList<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                res[s.peek()] = i - s.pop();
            }
            s.push(i);
        }
        return res;
    }
}
