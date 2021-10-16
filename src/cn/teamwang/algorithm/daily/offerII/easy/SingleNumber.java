package cn.teamwang.algorithm.daily.offerII.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * todo review
 *
 * 剑指 Offer II 004. 只出现一次的数字
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums1 = {2, 2, -3, 2};
        int[] nums2 = {0, 1, 0, 1, 0, 1, 100};
        int[] nums3 = {-2, -2, 1, 1, 4, 1, 4, 4, -4, -2};
//        System.out.println(singleNumber(nums1));
//        System.out.println(singleNumber(nums2));
//        System.out.println(singleNumber1(nums1));
//        System.out.println(singleNumber1(nums2));
//        System.out.println(singleNumber(nums3));

        System.out.println(singleNumber2(nums1));
        System.out.println(singleNumber1(nums1));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        for (Integer num : cnt.keySet()) {
            if (cnt.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 所有数字的二进制位之和再mod3的余数构成的二进制数就是res
     */
    public static int singleNumber1(int[] nums) {
        int[] seq = new int[32];
        int res = 0;

        for (int bit = 0; bit < 32; bit++) {
            for (int num : nums) {
                seq[bit] += ((num >> (31 - bit)) & 1);
            }
        }
        // 重最高位开始构建，故左移
        for (int bit = 0; bit < 32; bit++) {
            res = (res << 1) + seq[bit] % 3;
        }
        return res;
    }

    //将整数的各个数位上的加起来，然后对3取余，若结果为0，则待求数字在该位上是0；
    //若结果为1，则待求数字在该位上是1.
    public static int singleNumber2(int[] nums) {
        //java的int整型为32位
        int[] arr = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                arr[i] += (num >> (31 - i)) & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + arr[i] % 3;
        }

        return res;
    }
}
