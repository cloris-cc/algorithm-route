package cn.teamwang.algorithm.daily.leetcode;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-2147483646));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int count = 0; // 二进制1的个数，仅1个满足

        for (int bit = 0; bit <= 30; bit++) {
            count += (n >> bit) & 1;
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
