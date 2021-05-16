package cn.teamwang.algorithm.daily.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 5761. 找出和为指定值的下标对
 * <p>
 * todo 御坂御坂 contest timeout ^ ^
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> map2 = new HashMap<>();


    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        // 在此处初始化map2，节约count方法时间。因为构造函数调用次数远少于count
        // 统计每次数字出现的次数
        for (int m : nums2) {
            if (map2.containsKey(m)) {
                map2.put(m, map2.get(m) + 1);
            } else {
                map2.put(m, 1);
            }
        }
    }

    /**
     * 累加 ，将一个正整数加到 nums2 中指定下标对应元素上。
     *
     * @param index nums2 中指定下标
     * @param val   给定的值
     */
    public void add(int index, int val) {
        // 更新map2。index的原值次数-1，新的val值+1
        if (map2.get(nums2[index]) == 1) {
            map2.remove(nums2[index]);
        } else {
            map2.put(nums2[index], map2.get(nums2[index]) - 1);
        }

        this.nums2[index] += val;

        if (map2.containsKey(nums2[index])) {
            map2.put(nums2[index], map2.get(nums2[index]) + 1);
        } else {
            map2.put(nums2[index], 1);
        }
    }

    /**
     * 方法一：穷举法O(n^2)。
     * <p>
     * 满足 nums1[i] + nums2[j] = tot 的下标对 (i, j) 数目
     *
     * @param tot 目标值
     * @return 满足条件的下标对数目
     */
    public int count1(int tot) {
        int count = 0;
        // 穷举所有情况？
        // 不是有序的，故无法用左右指针。用哈希表叭。
        for (int n : nums1) {
            for (int m : nums2) {
                if (n + m == tot) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 哈希表O(nlogn)。此外，因为数组不是有序的，所以无法用左右指针。
     * <p>
     * 提示：
     * <p>
     * 1 <= nums1.length <= 1000 // 常数
     * 1 <= nums2.length <= 10^5 // 真正的N
     */
    public int count2(int tot) {
        int count = 0;

        for (int n : nums1) {
            int target = tot - n;
            if (map2.containsKey(target)) {
                count += map2.get(target);
            }
        }
        return count;
    }
}
