package cn.teamwang.algorithm.daily.leetcode;

/**
 * 7. 整数反转
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse1(Integer.MIN_VALUE)
        );
    }

    /**
     * 可以用StringBuilder
     */
    public static int reverse1(int x) {
        String s = String.valueOf(x);
        String t = "";
        int len = s.length();

        if (s.charAt(0) == '-') {
            t += '-';
            len -= 1;
        }
        for (int i = 0; i < len; i++) {
            t += s.charAt(s.length() - 1 - i);
        }
        System.out.println(t);

        long res = Long.parseLong(t);

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) res;
        }
    }

    /**
     * StringBuilder反转
     */
    public static int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            // 123%10=3 123/10=12
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (int) res == res ? (int) res : 0;
    }
}
