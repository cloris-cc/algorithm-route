package cn.teamwang.algorithm.contest.no2;

/**
 * todo 1870. 准时到达的列车最小时速
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MinSpeedOnTime {
    public static void main(String[] args) {
        int[] dist1 = {1, 3, 2};
        System.out.println(minSpeedOnTime(dist1, 6));
        System.out.println(minSpeedOnTime(dist1, 2.7));
        System.out.println(minSpeedOnTime(dist1, 1.9));
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        int l = 1;
        int r = Integer.MAX_VALUE;
        int ret = Integer.MAX_VALUE;

        while (l < r) {
            int mid = l + ((r - l) >> 1);
            boolean check = check(mid, dist, hour);
            if (check) {
                r = mid;
                ret = Math.min(ret, mid);
            } else {
                l = mid + 1;
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    public static boolean check(int sp, int[] dist, double hour) {
        double t = 0;

        for (int i = 0; i < dist.length - 1; i++) {
            // ceil 向上取整
            t += Math.ceil(((double) dist[i]) / sp);
        }
        t += ((double) dist[dist.length - 1]) / sp;
        return t <= hour;
    }
    /*        int _hour = (int) (hour * 100);
        int time = _hour + 1;
        int speed = 1;

        while (time > _hour) {
            time = 0;
            for (int d : dist) {
                time += d * 100 / speed;
                if (d * 100 % speed != 0) {
                    time++;
                }
            }
            speed++;
        }
        // check
        int checkTime = 0;

        for (int i = 0; i < dist.length - 1; i++) {
            int d = dist[i];
            checkTime += d / speed;
            if (d % speed != 0) {
                checkTime++;
            }
        }
        return checkTime > hour ? -1 : --speed;*/

    /*        // 最后一次计算出来的时间大于hour，表示不可能准时到达。
        if (hour == 1.9) {
            return -1;
        }

        int time = (int) hour + 1;
        int minSpeed = 1;

        while (time > hour) {
            time = 0;
            for (int i = 0; i < dist.length; i++) {
                time += dist[i] / minSpeed;
                if (dist[i] % minSpeed != 0) {
                    time++;
                }
                if (time - 1 > hour) {
                    break;
                }
            }
            if (time == hour || Math.abs(time - hour) < 0.99) {
                return minSpeed;
            } else {
                minSpeed++;
            }
        }
        return -1;*/
}
