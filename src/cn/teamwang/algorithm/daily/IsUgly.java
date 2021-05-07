package cn.teamwang.algorithm.daily;

/**
 * 263. 丑数
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class IsUgly {
    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));
        System.out.println(isUgly(1));
    }

    /**
     * 时间复杂度：O(logN)，时间复杂度取决于对n除以2，3，5的次数，由于每次至少将n除以2，因此时间复杂度不会超过o(logN)
     */
    public static boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }

        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }

        return n == 1;
    }
}
