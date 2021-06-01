package cn.teamwang.algorithm.daily.leetcode;

/**
 * 477. 汉明距离总和
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class TotalHammingDistance {
    public static void main(String[] args) {
        int[] nums1 = {4, 14, 2};
        int[] nums2 = {4, 14, 4};
        System.out.println(totalHammingDistance1(nums1));
        System.out.println(totalHammingDistance1(nums2));
        System.out.println(totalHammingDistance2(nums1));
        System.out.println(totalHammingDistance2(nums2));
        System.out.println(totalHammingDistance3(nums1));
        System.out.println(totalHammingDistance3(nums2));
    }

    /**
     * 异或运算哈希表
     */
    public static int totalHammingDistance1(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                String t = Integer.toBinaryString(nums[i] ^ nums[j]);
                for (char c : t.toCharArray()) {
                    if (c == '1') {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 异或运算哈希表
     * 2^3^9<10^9< 2^30 <2^4^9
     */
    public static int totalHammingDistance2(int[] nums) {
        int res = 0;

        for (int bit = 0; bit < 30; bit++) {
            int zero = 0, one = 0;

            for (int num : nums) {
                String s = Integer.toBinaryString(num);
                // 补全30位
                while (s.length() < 30) {
                    s = "0" + s;
                }
                if (s.charAt(bit) == '1') {
                    one++;
                } else {
                    zero++;
                }
            }
            // 长度位n的数组nums的所有元素二进制的第i位有c个1，n-c个0，则汉明距离之和位c*(n-c)
            res += one * zero;
        }
        return res;
    }

    public static int totalHammingDistance3(int[] nums) {
        int res = 0;

        for (int bit = 0; bit < 30; bit++) {
            int one = 0;
            for (int num : nums) {
                one += (num >> bit) & 1;
            }
            res += one * (nums.length - one);
        }
        return res;
    }
}
