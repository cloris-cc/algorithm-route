package cn.teamwang.algorithm.temp;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(test2(123));
        System.out.println(test2(42324));
        System.out.println(test2(120021));

        System.out.println(test2(1211));
    }

    public static boolean test1(int x) {
        char[] c = String.valueOf(x).toCharArray(); // length:5/2=2yes 6/2=3yes
        for (int i = 0; i < c.length / 2; i++) {
            if (c[i] != c[c.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 121 / 10 = 12..1 1..2 0..1
     * 123 / 10 = 12..3 1..2 0..1
     * 120021 / 10 = 12002..1 1200..2 120..0
     */
    public static boolean test2(int x) {
        int res = 0;
        int temp = x;
        System.out.println("x:" + x);
        while (temp != 0) {
            res = res * 10 + temp % 10; // first:3, second(res*10+now):32
            temp /= 10;
        }

        System.out.println("res:" + res);
        return x == res;
    }
}
