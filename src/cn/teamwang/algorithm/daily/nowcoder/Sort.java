package cn.teamwang.algorithm.daily.nowcoder;

import java.util.*;

/**
 * ε»ι + ζεΊ
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        System.out.println(set);
    }
}
