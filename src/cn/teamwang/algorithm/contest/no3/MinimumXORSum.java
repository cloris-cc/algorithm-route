package cn.teamwang.algorithm.contest.no3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * todo
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MinimumXORSum {
    public static void main(String[] args) {
        System.out.println((1 ^ 2) + (2 ^ 3));
        System.out.println((1 ^ 3) + (2 ^ 2));
        // 0 1 3, 3,4,5 & 5,4,3
        System.out.println(3 + (1 ^ 4) + (3 ^ 5));
        System.out.println(5 + (1 ^ 4));
    }

    public static int minimumXORSum(int[] nums1, int[] nums2) {
        int res = 0;
        // 排序，0放中间
        int[] t = new int[nums1.length];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int cnt = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                cnt++;
            } else {
                break;
            }
        }



        return res;
    }
}
