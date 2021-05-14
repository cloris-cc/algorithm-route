package cn.teamwang.algorithm.daily.leetcode;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman1(3));
        System.out.println(intToRoman1(4));
        System.out.println(intToRoman1(9));
        System.out.println(intToRoman1(58));
        System.out.println(intToRoman1(1994));
    }

    public static String intToRoman1(int num) {
        StringBuilder s = new StringBuilder();
        //1 <= num <= 3999
        int m = num / 1000; // num=3999, m=3
        int d = num % 1000 / 500; // 999 / 500 = 1
        int c = num % 1000 % 500 / 100;
        int l = num % 1000 % 500 % 100 / 50;
        int x = num % 1000 % 500 % 100 % 50 / 10;
        int v = num % 1000 % 500 % 100 % 50 % 10 / 5;
        int i = num % 1000 % 500 % 100 % 50 % 10 % 5;
//        System.out.println(m + " " + d + " " + c + " " + l + " " + x + " " + v + " " + i);

        // 先按正常流程，再插入 6 种特殊情况
        for (int i1 = 0; i1 < m; i1++) {
            s.append("M");
        }
        // 获取百位数。CM900替换DCCCC CD400替换CCCC
        if (num % 1000 / 100 == 9) {
            s.append("CM");
            d -= 1;
            c -= 4;
        }
        if (num % 1000 / 100 == 4) {
            s.append("CD");
            c -= 4;
        }
        for (int i1 = 0; i1 < d; i1++) {
            s.append("D");
        }
        for (int i1 = 0; i1 < c; i1++) {
            s.append("C");
        }
        // 获取十位数。XC90替换LXXXX XL40替换XXXX
        if (num % 1000 % 100 / 10 == 9) {
            s.append("XC");
            l -= 1;
            x -= 4;
        }
        if (num % 1000 % 100 / 10 == 4) {
            s.append("XL");
            x -= 4;
        }
        for (int i1 = 0; i1 < l; i1++) {
            s.append("L");
        }
        for (int i1 = 0; i1 < x; i1++) {
            s.append("X");
        }
        // 获取个位数 IX9替换VIIII IV4替换IIII
        if (num % 1000 % 100 % 10 == 9) {
            s.append("IX");
            v -= 1;
            i -= 4;
        }
        if (num % 1000 % 100 % 10 == 4) {
            s.append("IV");
            i -= 4;
        }
        for (int i1 = 0; i1 < v; i1++) {
            s.append("V");
        }
        for (int i1 = 0; i1 < i; i1++) {
            s.append("I");
        }
        return s.toString();
    }

}
