package cn.teamwang.algorithm.daily.nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] nums2 = {3, 3, 3, 3, 2, 2, 2};
        int[] nums3 = {1};
        System.out.println(MoreThanHalfNum_Solution1(nums1));
        System.out.println(MoreThanHalfNum_Solution1(nums2));
        System.out.println(MoreThanHalfNum_Solution1(nums3));
        System.out.println();
        System.out.println(MoreThanHalfNum_Solution2(nums1));
        System.out.println(MoreThanHalfNum_Solution2(nums2));
        System.out.println(MoreThanHalfNum_Solution2(nums3));
    }

    /**
     * 最直接的方法：用map来统计每个数字出现的次数，时间复杂度O(n)，空间复杂度O(n)
     * 其它方法：排序，再用二分查找。如果排序的时间复杂度比O(n)小的话就可以，听说是O(nlogn)，还是比O(n)大
     */
    public static int MoreThanHalfNum_Solution1(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }

    public static int MoreThanHalfNum_Solution2(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            // 统计次数，当超过一半可以提前停止。
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
                if (map.get(i) > array.length / 2) {
                    return i;
                }
            } else {
                map.put(i, 1);
            }
        }
        return array[0];
    }
}
