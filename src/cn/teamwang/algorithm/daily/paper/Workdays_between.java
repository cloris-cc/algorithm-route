package cn.teamwang.algorithm.daily.paper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Workdays_between {
    public static void main(String[] args) {
        System.out.println(workdays_between(1,1,1,2019,9,25));
    }

    public static int workdays_between(int y1, int m1, int d1, int y2, int m2, int d2) {
        int res = 0;
        Calendar c1 = new GregorianCalendar(y1, m1 - 1, d1);
        Calendar c2 = new GregorianCalendar(y2, m2 - 1, d2);

        // 1. 求c1星期几
        int w = c1.get(Calendar.DAY_OF_WEEK) - 1; // 0:星期天 1:星期一

        // 2. 计算相差多少天
        long days = (c2.getTimeInMillis() - c1.getTimeInMillis()) / (1000 * 3600 * 24) + 1;

        // 3. 统计工作日
        res += (int) days;
        res -= days / 7 * 2;
        int mod = (int) (days % 7);
        for (int i = 1; i <= mod; i++) {
            int t = w + i;
            if (t >= 7) {
                t -= 7;
            }
            if (t == 6 || t == 0) {
                res--;
            }
        }
        return res;
    }
}
