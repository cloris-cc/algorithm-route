package cn.teamwang.algorithm.daily.nowcoder;

import java.util.*;

/**
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 * https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=188&tqId=38293&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MaxLength {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4, 5};
        int[] nums2 = {2, 2, 3, 4, 3};
        System.out.println(maxLength(nums1));
        System.out.println(maxLength(nums2));
    }

    /**
     * 滑动窗口
     */
    public static int maxLength(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int max = 0, l = 0, r = -1;
        // 用来统计每个数字(或字符)出现的次数，可以用map
        // 用来统计每个数字(或字符)是否出现过，用set
        Set<Integer> freq = new HashSet<>();

        while (l < arr.length - 1 && r < arr.length - 1) {
            if (!freq.contains(arr[r+1])) {
                r++;
                freq.add(arr[r]);
            } else {
                freq.remove(arr[l]);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
