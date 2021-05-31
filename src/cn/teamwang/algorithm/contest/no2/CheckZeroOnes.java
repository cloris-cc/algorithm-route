package cn.teamwang.algorithm.contest.no2;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CheckZeroOnes {
    public static void main(String[] args) {
        System.out.println(checkZeroOnes1("1101"));
        System.out.println(checkZeroOnes1("111000"));
        System.out.println(checkZeroOnes1("110100010"));
    }

    public static boolean checkZeroOnes2(String s) {
        int max1 = 0, max0 = 0;
        int len1 = 0, len0 = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                len0 = 0;
                len1++;
            } else {
                len1 = 0;
                len0++;
            }
            max1 = Math.max(max1, len1);
            max0 = Math.max(max0, len0);
        }

        return max1 > max0;
    }

    /**
     * O(n^3)
     * 发挥不稳定
     */
    public static boolean checkZeroOnes1(String s) {
        int oneLen = 0, zeroLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                // "abc" 0,3
                int t = check(s.substring(i, j));
                if (t == 0) {
                    zeroLen = Math.max(zeroLen, j - i);
                }
                if (t == 1) {
                    oneLen = Math.max(oneLen, j - i);
                }
            }
        }
        return oneLen > zeroLen;

    }

    private static int check(String s) {
        // 全部0返回0， 1返回1， -1
        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count0++;
            }
            if (s.charAt(i) == '1') {
                count1++;
            }
            if (count0 == s.length()) {
                return 0;
            }
            if (count1 == s.length()) {
                return 1;
            }
        }
        return -1;
    }
}
