package cn.teamwang.algorithm.daily.offerII.medium;

import java.util.*;

/**
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {};
        int[] nums3 = {0};
        int[] nums4 = {-2, 0, 1, 1, 2};
        System.out.println(threeSum(nums1));
        System.out.println(threeSum(nums2));
        System.out.println(threeSum(nums3));
        System.out.println(threeSum(nums4));
        System.out.println(threeSum1(nums1));
        System.out.println(threeSum1(nums2));
        System.out.println(threeSum1(nums3));
        System.out.println(threeSum1(nums4));
    }

    /**
     * 无序数组无法用二分、双指针，因此用哈希表O(n^2*logN)，Timeout。
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // duplicate removal
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            /*
             * two-sum
             */
            for (int j = i + 1; j < nums.length; j++) {
                int t = target - nums[j];
                if (map.containsValue(t)) {
                    res.add(Arrays.asList(nums[i], nums[j], t));
                }
                map.put(j, nums[j]);
            }
            // restart two-sum
            map.clear();
        }
        return res;
    }

    /**
     * 双指针
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            // double pointer
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
