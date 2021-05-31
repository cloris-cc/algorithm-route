package cn.teamwang.algorithm.contest.no4;

/**
 * 5773. 插入后的最大值
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MaxValue {
    public static void main(String[] args) {
//        System.out.println(maxValue("99", 9));
//        System.out.println(maxValue("-13", 2));
//        System.out.println(maxValue("-132", 3));
//        System.out.println(maxValue("28824579515", 8));
//        System.out.println(maxValue("962942516613939", 3));
        System.out.println("abc".substring(0, 0)); // 空字符串
    }

    /**
     * 思路大致上没错就是想的太复杂了 TT
     */
    public static String maxValue(String n, int x) {
        // 正数：小于前 或 大于后
        // 负数：大于前 或 小于后
        if (n.charAt(0) == '-') { // 负数
            for (int i = 1; i < n.length(); i++) {
                if (x < n.charAt(i) - '0') {
                    return n.substring(0, i) + x + n.substring(i);
                }
            }
        } else { // 正数
            for (int i = 0; i < n.length(); i++) {
                if (x > n.charAt(i) - '0') {
                    return n.substring(0, i) + x + n.substring(i);
                }
            }
        }
        return n + x;
    }

    /**
     * timeout
     */
    public static String maxValue2(String n, int x) {
        // 正数：小于前，大于后
        // 负数：大于前，小于后
        String res = "";
        boolean flag = true;
        int t = 0;
        if (n.charAt(0) == '-') {
            t = 1;
        }


        for (int i = t; i < n.length(); i++) {
            if (n.charAt(0) != '-') {
                // 开头
                if (x > n.charAt(0) - '0') {
                    return x + n;
                }
                // 中间
                if (flag && i + 1 < n.length() && x <= n.charAt(i) - '0' && x > n.charAt(i + 1) - '0') {
                    res += n.charAt(i);
                    res += x;
                    flag = false;
                } else {
                    res += n.charAt(i);
                }
            } else { // 负数
                // 开头
//                System.out.println("来了吗");
                if (x < n.charAt(1) - '0') {
                    System.out.println("ya");
                    return "-" + x + n.substring(1);
                }
                // 中间
                if (flag && i + 1 < n.length() && x >= n.charAt(i) - '0' && x < n.charAt(i + 1) - '0') {
                    res += n.charAt(i);
                    res += x;
                    flag = false;
                } else {
                    res += n.charAt(i);
                }
            }
        }

        // 最后
        if (n.charAt(0) != '-' && flag) {
            res += x;
        }
        if (n.charAt(0) == '-' && flag) {
            res += x;
        }
        if (n.charAt(0) == '-') {
            res = "-" + res;
        }
        return res;
    }
}
