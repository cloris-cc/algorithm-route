package cn.teamwang.algorithm.daily.leetcode;

import java.util.*;

/**
 * todo 就是不想看了 1787. 使所有区间的异或结果为零
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MinChanges {
    public static void main(String[] args) {
        System.out.println(26^19);
        int[] nums1 = {1, 2, 0, 3, 0};
        int[] nums2 = {3, 4, 5, 2, 1, 7, 3, 4, 7};
        int[] nums3 = {1, 2, 4, 1, 2, 5, 1, 2, 6};
        int[] nums4 = {26, 19, 19, 28, 13, 14, 6, 25, 28, 19, 0, 15, 25, 11};
        /*
        [26, 19, 19, 28, 13, 14, 6, 25, 28, 19, 0, 15, 25, 11]
        [0, 19, 19, 0, 19, 19, 0, 19, 19, 0, 19, 19, 0, 19]
        12 （right 11）
        26^19=9 [26, 19, 9] 区间是分开的不是连续！
         */
//        System.out.println(minChanges(nums1, 1));
//        System.out.println(minChanges(nums2, 3));
//        System.out.println(minChanges(nums3, 3));
        System.out.println(minChanges(nums4, 3));
    }

    /**
     * 对一个数组而言，只改一个数就能使异或结果等于0
     * 全部k区间的数全部相同
     */
    public static int minChanges(int[] nums, int k) {
        System.out.println(Arrays.toString(nums));
        int res = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int origin = nums[0]; // 要改的数
        int xor_k = 0; // 0~k异或结果

        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        for (int i = 0; i < k; i++) {
            xor_k ^= nums[i];
        }

        // 找出要改的数字
        if (xor_k != 0) {
            int index = 0;
            for (int i = 0; i < k; i++) {
                if (freq.get(nums[i]) < freq.get(origin)) {
                    origin = nums[i];
                    index = i;
                }
            }
            res++;
            // target 改成 newVal
            int newVal = origin ^ xor_k;
            nums[index] = newVal;
        }

        // 修改数组
        for (int i = k; i < nums.length; i++) {
            if (nums[i] != nums[i - k]) {
                res++;
                nums[i] = nums[i - k];
            }
        }
        System.out.println(Arrays.toString(nums));
        return res;
    }

    // x 的范围为 [0, 2^10)
    static final int MAXX = 1 << 10;
    // 极大值，为了防止整数溢出选择 INT_MAX / 2
    static final int INFTY = Integer.MAX_VALUE / 2;

    public static int minChanges_answer(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[MAXX];
        Arrays.fill(f, INFTY);
        // 边界条件 f(-1,0)=0
        f[0] = 0;

        for (int i = 0; i < k; ++i) {
            // 第 i 个组的哈希映射
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            int size = 0;
            for (int j = i; j < n; j += k) {
                cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
                ++size;
            }

            // 求出 t2
            int t2min = Arrays.stream(f).min().getAsInt();

            int[] g = new int[MAXX];
            Arrays.fill(g, t2min);
            for (int mask = 0; mask < MAXX; ++mask) {
                // t1 则需要枚举 x 才能求出
                for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                    int x = entry.getKey(), countx = entry.getValue();
                    g[mask] = Math.min(g[mask], f[mask ^ x] - countx);
                }
            }

            // 别忘了加上 size
            for (int j = 0; j < MAXX; ++j) {
                g[j] += size;
            }
            f = g;
        }

        return f[0];

    }
}
