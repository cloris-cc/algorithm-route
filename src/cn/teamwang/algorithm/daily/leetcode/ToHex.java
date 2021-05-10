package cn.teamwang.algorithm.daily.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 405. 数字转换为十六进制数
 * <p>
 * 对于负整数，使用 补码运算 方法。
 * 1 正数的原码、反码和补码都相同。
 * 2 负数原码和反码的相互转换：符号位不变，数值位按位取反。
 * 3 负数原码和补码的相互转换：符号位不变，数值位按位取反,末位再加1。
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class ToHex {
    public static void main(String[] args) {
        System.out.println(toHex1(26));
        System.out.println(toHex1(-1));
    }

    public static String toHex1(int num ) {
        if (num == 0)
            return "0";
        char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 8 && num != 0) {
            sb.append(chars[num & 0xf]);
            num >>= 4;
        }
        return sb.reverse().toString();
    }

    /**
     * error while -100000
     */
    public static String toHex2(int num) {
        if (num == 0) {
            return "0";
        }

        String res = "";
        Map<Integer, Character> map = new HashMap<>();
        map.put(10, 'a');
        map.put(11, 'b');
        map.put(12, 'c');
        map.put(13, 'd');
        map.put(14, 'e');
        map.put(15, 'f');

        if (num > 0) {
            while (num != 0) {
                int mod = num % 16;
                if (mod > 9) {
                    res = map.get(mod) + res;
                } else {
                    res = mod + res;
                }
                num = num / 16;
            }
        } else {
            int count = 0;
            num = Math.abs(num);
            while (num != 0) {
                int mod = num % 16;
                // 先转反码，再求补码
                mod = 15 - mod;
                if (count == 0) {
                    mod++;
                }
                if (mod > 9) {
                    res = map.get(mod) + res;
                } else {
                    res = mod + res;
                }

                num = num / 16;
                count++;
            }
            int len = res.length();
            for (int i = 0; i < 8 - len; i++) {
                res = "f" + res;
            }
        }
        return res;
    }
}
