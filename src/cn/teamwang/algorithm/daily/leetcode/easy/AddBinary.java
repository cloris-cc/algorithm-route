package cn.teamwang.algorithm.daily.leetcode.easy;

/**
 * 67. 二进制求和
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class AddBinary {
    public static void main(String[] args) {
//        System.out.println(addBinary("11", "1"));
//        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("1", "111"));
    }

    public static String addBinary(String a, String b) {
        // return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
        return a.length() >= b.length() ? sum(a, b) : sum(b, a);
    }

    private static String sum(String s1, String s2) {
        String res = "";
        boolean flag = false;

        for (int i = s2.length() - 1; i >= 0; i--) {
            int t = (s1.charAt(i) - '0') + (s2.charAt(i) - '0');
            if (flag) {
                t++;
            }
            if (t == 2) {
                res += "0";
                flag = true;
            } else {
                res += t;
                flag = false;
            }

        }
        if (!flag) { // 不需要再进1了，直接加上剩余字符即可。
            for (int i = s1.length() - s2.length() - 1; i >= 0; i--) {
                res += s1.charAt(i);
            }

        } else if (flag && s1.length() == s2.length()) {
            flag = false;
            res += 1;
        } else {
            flag = false;
            for (int i = s1.length() - s2.length() - 1; i >= 0; i--) {
                int t = s1.charAt(i) - '0' + 1;
                if (flag) {
                    t++;
                }
                if (t == 2) {
                    res += "0";
                    flag = true;
                } else {
                    res += t;
                    flag = false;
                }
            }
        }
        String finalRes = new StringBuffer(res).reverse().toString();
        return flag ? "1" + finalRes : finalRes;
    }

}
