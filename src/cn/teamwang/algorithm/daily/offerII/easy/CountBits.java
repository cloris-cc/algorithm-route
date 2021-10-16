package cn.teamwang.algorithm.daily.offerII.easy;

import java.util.Arrays;

/**
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CountBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
    }

    /**
     * count bit '1'
     */
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int num = 0; num <= n; num++) {
            int count = 0;
            for (int i = 0; i < 31; i++) {
                count += (num >> i) & 1;
            }
            res[num] = count;
        }
        return res;
    }
}
