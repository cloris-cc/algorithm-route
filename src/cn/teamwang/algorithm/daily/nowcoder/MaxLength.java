package cn.teamwang.algorithm.daily.nowcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 * https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=188&tqId=38293&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MaxLength {
    public static void main(String[] args) {
//        int[] nums1 = {2, 3, 4, 5};
        int[] nums2 = {2, 2, 3, 4, 3};
//        System.out.println(maxLength(nums1));
        System.out.println(maxLength(nums2));
    }

    /**
     * 先不考虑动态规划/双指针/滑动窗口，用自己的方法做出来先。
     */
    public static int maxLength(int[] arr) {
        int max = 1;
        int len = 1;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            list.add(arr[i]);
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (list.contains(arr[j])) {
                    list.clear();
                } else {
                    list.add(arr[j]);
                    len++;
                }
                max = Math.max(len, max);
            }
        }

        return max;
    }
}
