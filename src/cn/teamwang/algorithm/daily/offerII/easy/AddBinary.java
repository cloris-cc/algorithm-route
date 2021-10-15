package cn.teamwang.algorithm.daily.offerII.easy;

/**
 * 剑指 Offer II 002. 二进制加法
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "10"));
        System.out.println(addBinary("1010", "1011"));
    }

    /**
     * ![woi4by](https://gitee.com/jacky_cloud/oss/raw/master/uPic/woi4by.png)
     */
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int n = Math.max(a.length(), b.length());
        int carry = 0;

        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            res.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            res.append('1');
        }
        return res.reverse().toString();

    }
}
