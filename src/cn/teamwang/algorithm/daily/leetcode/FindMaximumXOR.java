package cn.teamwang.algorithm.daily.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. 数组中两个数的最大异或值
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class FindMaximumXOR {
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR1(nums));
        System.out.println(findMaximumXOR2(nums));

    }

    /**
     * 穷举 O(n^2)
     */
    public static int findMaximumXOR1(int[] nums) {
        int res = 0; // 自己异或

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }
        return res;
    }

    /**
     * todo 暂时不想看(是真的看不懂)
     * 0 <= nums[i] <= 2^31 -1
     * 哈希表
     */
    public static int findMaximumXOR2(int[] nums) {
        int res = 0;

        for (int k = 30; k >= 0; k--) { // 从二进制的最高位开始
            Set<Integer> set = new HashSet<>();
            // 将所有的 pre^k(a_j) 放入哈希表中
            for (int num : nums) {
                // 如果只想保留从最高位开始到第 k 个二进制位为止的部分
                // 只需将其右移 k 位
                set.add(num >> k);
            }

            // 目前 x 包含从最高位开始到第 k+1 个二进制位为止的部分
            // 我们将 x 的第 k 个二进制位置为 1，即为 x = x*2+1
            int xNext = res * 2 + 1;
            boolean found = false;

            // 枚举 i
            for (int num : nums) {
                if (set.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }

            if (found) {
                res = xNext;
            } else {
                // 如果没有找到满足等式的 a_i 和 a_j，那么 x 的第 k 个二进制位只能为 0
                // 即为 x = x*2
                res = xNext - 1;
            }
        }
        return res;
    }
}
