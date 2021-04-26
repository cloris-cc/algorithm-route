package cn.teamwang.algorithm.temp;

import java.util.Scanner;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class BeautifulNumberLarge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int j = in.nextInt();
        for (int i = 1; i <= j; i++) {
            int n = in.nextInt();
            System.out.println("Case#" + i + ": " + beautiful(n));
        }

    }

    /**
     * n --> r进制 --> 111...1(k个1)
     * 即 N = r^(k-1) + r^(k-2) + ... + r + 1，由于k为指数故k的数字不可能很大。k的范围2~64
     * todo：二分查找时间复杂度
     */
    private static int beautiful(int n) {
        int minR = 2;
        int maxR = n - 1;

         for (int bits = 64; bits >= 2; bits--) {
            int midR = minR + (maxR - minR) / 2;

            int sum = 0;

            for (int i = bits - 1; i > 0; i--) { // i:63
                int count = 1;
                for (int j = 0; j < i; j++) { // 63次
                    count *= midR;
                    // 随时跳出
                    if (count > n) {
                        break;
                    }
                }
                sum += count;
                // 随时跳出
                if (sum > n) {
                    break;
                }
            }

            if (sum == n) {
                return midR;
            } else if (sum < n) {
                minR++;
            } else {
                maxR--;
            }

        }
        return -1;
    }
}
