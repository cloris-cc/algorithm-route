package cn.teamwang.algorithm.hash.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {2, 3, 4};
        int[] nums3 = {-1, 0};
        int[] nums4 = {1, 1};
        int[] nums5 = {1, 2, 3, 4, 4, 9, 56, 90};
        int[] nums6 = {3, 5, 5, 7};
//        System.out.println(Arrays.toString(twoSum1(nums1, 9)));
//        System.out.println(Arrays.toString(twoSum1(nums2, 6)));
//        System.out.println(Arrays.toString(twoSum1(nums3, -1)));
//        System.out.println(Arrays.toString(twoSum1(nums4, 2)));
//        System.out.println(Arrays.toString(twoSum1(nums5, 8)));
//        System.out.println(Arrays.toString(twoSum1(nums6, 10)));
//        System.out.println();
//        System.out.println(Arrays.toString(twoSum2(nums1, 9)));
//        System.out.println(Arrays.toString(twoSum2(nums2, 6)));
//        System.out.println(Arrays.toString(twoSum2(nums3, -1)));
        System.out.println(Arrays.toString(twoSum2(nums4, 2)));
        System.out.println(Arrays.toString(twoSum2(nums5, 8)));
        System.out.println(Arrays.toString(twoSum2(nums6, 10)));
        System.out.println();
        System.out.println(Arrays.toString(twoSum3(nums4, 2)));
        System.out.println(Arrays.toString(twoSum3(nums5, 8)));
        System.out.println(Arrays.toString(twoSum3(nums6, 10)));

    }

    /**
     * 省略穷举：二分查找O(nlogn)
     */
    public static int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int t = target - numbers[i];
            int l = i + 1, r = numbers.length - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] < t) {
                    l = mid + 1;
                } else if (numbers[mid] > t) {
                    r = mid - 1;
                } else {
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * 哈希表O(nlogn)
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int t = target - numbers[i];
            if (map.containsKey(t)) {
                res[0] = map.get(t) + 1;
                res[1] = i + 1;
            }
            map.put(numbers[i], i);
        }
        return res;
    }

    /**
     * 双指针（左右指针）O(n)
     */
    public static int[] twoSum3(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
