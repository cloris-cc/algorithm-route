package cn.teamwang.algorithm.daily.nowcoder;

import java.util.Arrays;

/**
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 *
 * https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=188&tqId=38285&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Target {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum1(nums, 6)));
        System.out.println(Arrays.toString(twoSum2(nums, 6)));
    }

    /**
     * O(N^2)
     * 先用一般方法，再考虑优化(排序+二分法)
     */
    public static int[] twoSum1(int[] numbers, int target) {
        // write code here
        int[] res = new int[2];

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * ERROR: 索引乱序了。
     * O(NlogN)
     */
    public static int[] twoSum2(int[] numbers, int target) {
        // write code here
        int[] res = new int[2];
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            int _target = target - numbers[i];
            int left = 0;
            int right = numbers.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] > _target) {
                    right = mid - 1;
                } else if (numbers[mid] < _target) {
                    left = mid + 1;
                } else {
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    return res;
                }
            }
        }
        return res;
    }
}
