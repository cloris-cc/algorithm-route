package cn.teamwang.algorithm.daily.nowcoder;

import java.util.Arrays;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MergeNums {
    public static void main(String[] args) {

    }

    /**
     * 因为数组有序，故双指针。
     */
    public static void merge(int A[], int m, int B[], int n) {
        int[] res = new int[m + n];
        int l1 = 0, l2 = 0;
        int curVal;

        while (l1 < m || l2 < n) {
            if (l1 == m) {
                curVal = B[l2++];
            } else if (l2 == n) {
                curVal = A[l1++];
            } else if (A[l1] < B[l2]) {
                curVal = A[l1++];
            } else {
                curVal = B[l2++];
            }
            res[l1 + l2 - 1] = curVal;
        }
        for (int i = 0; i < m + n; i++) {
            A[i] = res[i];
        }
    }
}
