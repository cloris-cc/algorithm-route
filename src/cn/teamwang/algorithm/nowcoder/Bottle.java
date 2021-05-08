package cn.teamwang.algorithm.nowcoder;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/test/question/fe298c55694f4ed39e256170ff2c205f?pid=1088888&tid=44179015
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Bottle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int empty = in.nextInt();
            System.out.println(bottle(empty));
        }
    }

    public static int bottle(int empty) {
        int res = 0;

        while (empty >= 3) {
            res += empty / 3;
            empty = empty / 3 + empty % 3;
        }
        if (empty == 2) {
            res++;
        }
        return res;
    }
}
