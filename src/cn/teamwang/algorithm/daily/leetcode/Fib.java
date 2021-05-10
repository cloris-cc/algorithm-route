package cn.teamwang.algorithm.daily.leetcode;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Fib {
    public static void main(String[] args) {
//        System.out.println(fib1(2));
//        System.out.println(fib2(2));
//        System.out.println(fib1(5));
//
//        System.out.println(fib2(5));
//        System.out.println(fib1(48) % 1000000007);
        System.out.println(fib2(48));
        System.out.println(fib2(95));
    }

    public static int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib1(n - 1) + fib1(n - 2);
        }
    }

    public static int fib2(int n) {
        if (n== 0 || n==1) {
            return n;
        }
        // 根据提示：0 <= n <= 100
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            nums[i] = (nums[i - 1] + nums[i - 2]) % 1000000007;
        }
        return nums[n];
    }
}
