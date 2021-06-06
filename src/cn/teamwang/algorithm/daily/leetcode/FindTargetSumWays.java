package cn.teamwang.algorithm.daily.leetcode;

/**
 * 494. 目标和
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class FindTargetSumWays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums, 3));
    }

    static int res = 0;

    public static int findTargetSumWays(int[] nums, int target) {
        // 2^n
        dfs(nums, target, 0, 0);
        return res;
    }

    public static void dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                res++;
            }
        } else {
            dfs(nums, target, index + 1, sum + nums[index]);
            dfs(nums, target, index + 1, sum - nums[index]);
        }
    }
}
