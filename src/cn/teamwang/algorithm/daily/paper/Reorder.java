package cn.teamwang.algorithm.daily.paper;

import java.util.Arrays;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Reorder {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 2, 2, 3};
        int[] nums3 = {3, 2, 1, 1, 2, 3};
        System.out.println(reorder(nums1));
        System.out.println(reorder(nums2));
        System.out.println(reorder(nums3));
    }

    /**
     * dp?
     */
    public static int reorder(int[] prices) {
        int res = 0;
        int l = 0, r = (prices.length - 1) / 2;
        int mid = (prices.length - 1) / 2;

        Arrays.sort(prices);
        while (l < mid && r + 1 < prices.length) {
            if (prices[l] < prices[r] && prices[l] < prices[r + 1]) {
                res++;
                r++;
            }
            l++;
        }
        return res;
    }
}
