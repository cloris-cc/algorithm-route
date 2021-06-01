package cn.teamwang.algorithm.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 17.18. 最短超串
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class ShortestSeq {
    public static void main(String[] args) {
        int[] big1 = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] small1 = {1, 5, 9};
        int[] big2 = {1, 2, 3};
        int[] small2 = {4};
        int[] big3 = {0, 1, 2, 3, 4, 5};
        int[] small3 = {4, 5};
//        System.out.println(Arrays.toString(shortestSeq1(big1, small1)));
//        System.out.println(Arrays.toString(shortestSeq1(big2, small2)));
        System.out.println(Arrays.toString(shortestSeq1(big3, small3)));
        System.out.println();
//        System.out.println(Arrays.toString(shortestSeq2(big1, small1)));
//        System.out.println(Arrays.toString(shortestSeq2(big2, small2)));
        System.out.println(Arrays.toString(shortestSeq2(big3, small3)));

    }

    /**
     * 暴力解法：穷举所有子串，判断是否满足后再找最短的那个。
     */
    public static int[] shortestSeq1(int[] big, int[] small) {
        List<Integer> sList = new ArrayList<>();
        List<Integer> tList = new ArrayList<>();
        int[] res = new int[3];
        // min length
        res[2] = Integer.MAX_VALUE;

        for (int num : small) {
            sList.add(num);
        }
        for (int i = 0; i < big.length; i++) {
            // 滑动窗口
            for (int j = i; j < big.length; j++) {
                tList.add(big[j]);
                // check, 不够继续添加
                if (tList.containsAll(sList)) {
                    if (tList.size() < res[2]) {
                        res[0] = i;
                        res[1] = j;
                        res[2] = tList.size();
                    }
                }
            }
            tList.clear();
        }
        return res[1] == 0 ? new int[0] : new int[]{res[0], res[1]};
    }

    /**
     * 滑动窗口
     */
    public static int[] shortestSeq2(int[] big, int[] small) {
        List<Integer> sList = new ArrayList<>();
        List<Integer> tList = new ArrayList<>();
        int l = 0, r = 0;
        int[] res = new int[3];
        res[2] = Integer.MAX_VALUE;

        for (int num : small) {
            sList.add(num);
        }
        boolean flag = false;
        while (l < big.length && r < big.length) {
            // big: 1 2 3 4 5
            // small: 4 5
            tList.add(big[r]);
            while (l <= r && tList.containsAll(sList)) {
                if (tList.size() < res[2]) {
                    res[0] = l;
                    res[1] = r;
                    res[2] = tList.size();
                }
                tList.remove(big[l]);
                l++;
                // restart
                flag = true;
            }
            if (flag) {
                l++;
                r = l;
                tList.clear();
                flag = false;
                continue;
            }
            r++;
        }
        return res[1] == 0 ? new int[0] : new int[]{res[0], res[1]};
    }
}
