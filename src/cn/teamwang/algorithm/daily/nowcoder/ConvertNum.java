package cn.teamwang.algorithm.daily.nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class ConvertNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        // c[i] - 'a'
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);

        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);

        while (in.hasNext()) {
            String str = in.next();
            str = str.replace('x', '0');
            System.out.println("输入转化：" + str);
            char[] c = str.toCharArray();
            int res = 0;

            for (int i = 0; i < c.length; i++) {
                // 数学公式：res += c[i] * 16^(c.length-1-i)
                // 幂运算可使用Math.pow(a, b)函数
                res += map.get(c[i]) * Math.pow(16, c.length - 1 - i);
            }
            System.out.println("结果：" + res);
        }

    }
}
