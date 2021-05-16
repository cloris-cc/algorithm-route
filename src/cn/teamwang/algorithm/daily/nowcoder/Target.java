package cn.teamwang.algorithm.daily.nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 * <p>
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
     * 穷举所有情况：O(N^2)
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
     * O(n)
     * 因为要查找的目标值也在数组内，所以可以通过哈希表来保存、获取目标值，而不是二次遍历数组。
     * 总结：穷举数组+答案唯一时，可考虑哈希表。
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            // 这里用num作为key是因为可以直接取出val。若使用索引作为key，则需要遍历才能通过val获取key。
            // key 重复也没关系，因为答案是唯一的。
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int num = target - numbers[i];
            if (map.containsKey(num) && i != map.get(num)) {
                res[0] = i + 1;
                res[1] = map.get(num) + 1;
                // 注意这里的 break
                break;
            }
        }
        return res;
    }

    public static int[] twoSum2_optimized(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * ERROR: 排序后索引乱序了。
     * O(NlogN)
     */
    public static int[] twoSum3(int[] numbers, int target) {
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
