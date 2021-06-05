package cn.teamwang.algorithm.hash.medium;

import java.util.*;

/**
 * 15. 三数之和
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {};
        int[] nums3 = {0};
        int[] nums4 = {-2, 0, 1, 1, 2}; // [[-2,0,2],[-2,1,1]]
        int[] nums5 = {0, 0, 0, 0};

//        System.out.println(threeSum1(nums1));
//        System.out.println(threeSum1(nums2));
        System.out.println(threeSum1(nums3));
        System.out.println(threeSum1(nums4));
        System.out.println(threeSum1(nums5));
//        System.out.println(threeSum2(nums1));
//        System.out.println(threeSum2(nums2));
        System.out.println(threeSum2(nums3));
        System.out.println(threeSum2(nums4));
        System.out.println(threeSum2(nums5));
    }

    /**
     * 哈希表 O(n^3)
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // key:index 因为不需要用到下标
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            int target = -nums[i];
            // 去重
            if (i > 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int t = target - nums[j];
                if (map.containsValue(t)) {
                    List<Integer> list = Arrays.asList(nums[i],nums[j],t);
                    if (!res.contains(list)) { // contains的时间复杂度是O(n)，会导致算法超时
                        res.add(list);
                    }
                }
                map.put(j, nums[j]);
            }
            map.clear();
        }
        return res;
    }

    /**
     * 双指针O(n^2)
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    res.add(list);
                    // 缩小范围继续找
                    l++;
                    r--;
                    // 去重
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

}
