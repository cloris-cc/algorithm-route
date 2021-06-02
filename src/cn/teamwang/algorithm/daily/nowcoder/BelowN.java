package cn.teamwang.algorithm.daily.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 老板给度度熊个数， 每一次从中取出一个最大的减去， 其他的个数加上， 一直重复直到最大的， 执行次数记为。
 * 老板想知道最少执行多少次操作使得个数都小于呢？
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class BelowN {
    public static void main(String[] args) {
        // 逆推
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            long k = 0;
            Arrays.sort(a);

            while (a[a.length - 1] >= n) {
                long times = 0;
                for (int i = 0; i < a.length; i++) {
                    if (a[i] >= n) {
                        // n=3 a[i]=5
                        times += a[i] / n;
                        a[i] -= n * (a[i] / n);
                    }
                }
                for (int i = 0; i < a.length; i++) {
                    a[i] += times;
                }
                k += times;
                Arrays.sort(a);
            }

            System.out.println(k);
        }
    }
}
