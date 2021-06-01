package cn.teamwang.algorithm.slidingwindow;

import java.util.*;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow1(nums, 3)));
    }

    /**
     * 暴力解法，时间复杂度O(nk)
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < res.length; i++) {
            int l = i, r = k - 1 + i; // row2nd: l=1,r=3,
            int max = nums[i];

            while (l <= r) {
                max = Math.max(max, nums[l]);
                l++;
            }
            res[i] = max;
        }
        return res;
    }

    /**
     * todo 单向队列，明天再看
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (!q.isEmpty() && i - q.peek() >= k) {
                q.poll();
            }
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                res[j++] = nums[q.peek()];
            }
        }

        return res;
    }
}
