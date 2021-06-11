package cn.teamwang.algorithm.daily.paper;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 每一次从数组中取出一个最大的数减去数组长度n，其余n-1个数加1，一直重复直到最大的数小于n，求最少执行次数。
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class BelowN {
    /**
     * 直接模拟
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            long[] nums = new long[n];
            long res = 0;

            for (int i = 0; i < n; i++) {
                nums[i] = in.nextLong();
            }
            while (!valid(nums)) {
                /*
                 * 每次只改那个最大值，再让其它n-1个数+1
                 */
                int index = 0;
                long max = 0;

                for (int i = 0; i < n; i++) { // 改二分
                    if (nums[i] > max) {
                        max = nums[i];
                        index = i;
                    }
                }
                // 先全部+1，再单独改最大值
                for (int i = 0; i < n; i++) {
                    nums[i] += max / n;
                }
                nums[index] = max % n;
                res += max / n;
            }
            System.out.println(res);
        }
    }

    private static boolean valid(long[] nums) {
        for (long n : nums) {
            if (n >= nums.length) {
                return false;
            }
        }
        return true;
    }
}
