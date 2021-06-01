package cn.teamwang.algorithm.daily.leetcode;

/**
 * 461. 汉明距离
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance1(1, 4));
        System.out.println(hammingDistance1(3, 1));
        System.out.println(hammingDistance2(1, 4));
        System.out.println(hammingDistance2(3, 1));
    }

    public static int hammingDistance1(int x, int y) {
        int res = 0;
        String s = Integer.toBinaryString(x ^ y);

        for (char c : s.toCharArray()) {
            if (c == '1') {
                res++;
            }
        }
        return res;
    }

    public static int hammingDistance2(int x, int y) {
        int res = 0;
        int t = x ^ y;

        for (int bit = 0; bit < 31; bit++) {
            res += (t >> bit) & 1;
        }
        return res;
    }


}
