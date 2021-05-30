package cn.teamwang.algorithm.daily.leetcode;

/**
 * 342. 4的幂
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class IsPowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(4));
    }

    public static boolean isPowerOfFour(int n) {
        // 移除二进制最低位1：n & (n - 1)
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
