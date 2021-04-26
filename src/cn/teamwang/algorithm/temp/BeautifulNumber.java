package cn.teamwang.algorithm.temp;

import java.util.Scanner;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class BeautifulNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int j = in.nextInt();
        for (int i = 1; i <= j; i++) {
            int n = in.nextInt();
            System.out.println("Case#" + i + ": " + beautiful(n));
        }

    }

    /**
     * 时间复杂度：NlogN
     */
    private static int beautiful(int n) {
        // n --> r进制 --> 111...1(k个1)
        // 即 N = r^(k-1) + r^(k-2) + ... + r + 1，由于k为指数故k的数字不可能很大。k的范围2~64，故代入N和k可以直接求出r

        for (int radix = 2; radix < n; radix++) {
            // 重置 n
            int y = n;

            while (y % radix == 1) {
                y /= radix;
                if (y == 0) {
                    return radix;
                }
            }
        }
        return -1;
    }
}
