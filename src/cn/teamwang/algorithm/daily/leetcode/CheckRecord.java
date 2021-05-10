package cn.teamwang.algorithm.daily.leetcode;

/**
 * 551. 学生出勤记录 I
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CheckRecord {
    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLP"));
        System.out.println(checkRecord("PPALLL"));
    }

    public static boolean checkRecord(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int a = 0;
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'A') {
                a++;
            }
            if (a > 1 || (i < c.length - 2 && c[i] == 'L' && c[i + 1] == 'L' && c[i + 2] == 'L')) {
                return false;
            }
        }
        return true;
    }
}
