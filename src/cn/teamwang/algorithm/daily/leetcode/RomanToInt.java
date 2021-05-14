package cn.teamwang.algorithm.daily.leetcode;

import java.util.HashMap;

/**
 * 13. 罗马数字转整数
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt1("III"));
        System.out.println(romanToInt1("IV"));
        System.out.println(romanToInt1("IX"));
        System.out.println(romanToInt1("LVIII"));
        System.out.println(romanToInt1("MCMXCIV"));
    }

    /**
     * 加
     */
    public static Integer romanToInt1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int sum = 0;

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < c.length; i++) {
            // 先一般；
            // 处理 3 种特殊规则
            if (i + 1 < c.length) {
                if ((c[i] == 'I' && (c[i + 1] == 'V' || c[i + 1] == 'X'))
                        || (c[i] == 'X' && (c[i + 1] == 'L' || c[i + 1] == 'C'))
                        || (c[i] == 'C' && (c[i + 1] == 'D' || c[i + 1] == 'M'))) {
                    sum += (map.get(c[i + 1]) - map.get(c[i]));
                    i++;
                } else {
                    sum += map.get(c[i]);
                }
            } else {
                sum += map.get(c[i]);
            }
        }
        return sum;
    }

}
