package cn.teamwang.algorithm.hash.easy;

/**
 * 剑指 Offer 03. 数组中重复的数字
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        int[] freq = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (++freq[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }
}
