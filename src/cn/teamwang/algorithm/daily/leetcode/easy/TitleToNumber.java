package cn.teamwang.algorithm.daily.leetcode.easy;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class TitleToNumber {
    public static void main(String[] args) {
//        System.out.println(titleToNumber("A"));
//        System.out.println(titleToNumber("AB"));
//        System.out.println(titleToNumber("AC"));
//        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("FXSHRXW"));
    }

    public static long titleToNumber(String columnTitle) {
        int res = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            res = res * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
