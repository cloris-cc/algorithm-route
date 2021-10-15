package cn.teamwang.algorithm.daily.offerII.easy;

/**
 * 剑指 Offer II 001. 整数除法
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Divide {
    public static void main(String[] args) {
//        System.out.println(divide(15, 2));
        System.out.println(divide(7, -3));
        System.out.println(divide(0, 1));
        System.out.println(divide(1, 1));
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(-2147483648, 1));
        System.out.println(divide(15, 2));
    }

    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int res = 0;
        boolean sign = (a > 0) ^ (b > 0);

        if (a > 0) a = -a;
        if (b > 0) b = -b;
        while (a <= b) {
            a -= b;
            res++;
        }
        return sign ? -res : res;
    }
}
