package cn.teamwang.algorithm.daily.nowcoder;

import java.util.Scanner;

/**
 * 度度熊请你找出两个数，满足且尽量大。输出最大的.
 * 其中表示和的最小公倍数，表示和的最大公约数。
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LcmAndGcd {

    /**
     * 从结果推导除当a=n-1,b=n时，lcm-gcd最大
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            long max = Integer.MIN_VALUE;
            int a = n - 1, b = n;
            while (b % a != 0) {
                int t = b;
                b = a;
                a = t % a;
            }
            max = Math.max(max, (long) n * (n - 1) / a - a);
            System.out.println(max);
        }
    }

    public static void main_1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int max = 0;
            // n<=10^9
            for (int a = 1; a <= n; a++) {
                for (int b = a + 1; b <= n; b++) {
                    int a1 = a, b1 = b;

                    // 辗转相除法
                    while (b1 % a1 != 0) {
                        int t = b1;
                        b1 = a1;
                        a1 = t % a1;
                    }
                    // a1为最大公约数gcd
                    System.out.println("a:" + a + " b:" + b + " max:" + (a * b / a1 - a1));
                    max = Math.max(max, a * b / a1 - a1);
                    // a*b/a1-a1 = a*b*a1 - a1^2
                }
            }
            System.out.println(max);
        }
    }
}
