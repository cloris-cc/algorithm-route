package cn.teamwang.algorithm.contest.no1;

import java.util.Arrays;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MemLeak {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(memLeak(2, 2)));
        System.out.println(Arrays.toString(memLeak(8, 11)));
    }

    /**
     * 时间复杂度：O(n)
     */
    public static int[] memLeak(int memory1, int memory2) {
        int[] res = new int[3];
        int i = 1;

        while (i <= Math.max(memory1, memory2)) {
            if (memory1 < memory2) {
                memory2 -= i;
            } else {
                memory1 -= i;
            }
            i++;
        }
        res[0] = i;
        res[1] = memory1;
        res[2] = memory2;
        return res;
    }
}
