package cn.teamwang.algorithm.daily.leetcode;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 * <p>
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？不能排序。使用下面给出的方法。
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect1(nums1, nums2)));
        System.out.println(Arrays.toString(intersect1(nums3, nums4)));
    }

    /**
     * 用list更简单
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        // nums2很大，说明有很多多余的数可以不用遍历
        for (int n : nums1) {
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }
        for (int n : nums2) {
            map2.put(n, map2.getOrDefault(n, 0) + 1);
        }
        add(list, map1, map2);
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void add(List<Integer> list, Map<Integer, Integer> small, Map<Integer, Integer> big) {
        // 遍历更短的
        if (big.size() < small.size()) {
            add(list, big, small);
        } else {
            // 取更小的val
            for (Map.Entry<Integer, Integer> e : small.entrySet()) {
                if (big.containsKey(e.getKey())) {
                    int times = Math.min(e.getValue(), big.get(e.getKey()));
                    for (int i = 0; i < times; i++) {
                        list.add(e.getKey());
                    }
                }
            }
        }
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> resList = new ArrayList<>();

        for (int num : nums1) {
            list1.add(num);
        }
        for (int num : nums2) {
            if (list1.contains(num)) {
                resList.add(num);
                // 从 list1 除去已匹配的数值
                list1.remove(Integer.valueOf(num));
            }
        }
        int[] res = new int[resList.size()];
        int i = 0;

        for (int num : resList) {
            res[i++] = num;
        }
        return res;
    }

}
