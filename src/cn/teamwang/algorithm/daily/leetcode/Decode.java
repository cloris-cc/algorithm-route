package cn.teamwang.algorithm.daily.leetcode;

import java.util.Arrays;

/**
 * 1734. 解码异或后的排列
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Decode {
    public static void main(String[] args) {
        int[] encoded1 = {3,1};
        int[] encoded2 = {6,5,4,6};
        int[] encoded3 = {12,6,11,10,5,3,4,6};
        System.out.println(Arrays.toString(decode(encoded1)));
        System.out.println(Arrays.toString(decode(encoded2)));
        System.out.println(Arrays.toString(decode(encoded3)));
    }


    /**
     * pre:
     * 第一反应是从2进制运算中找规律，找了好久都没找到哎。
     * 1. 相同数异或运算都是0，从运算原理(二进制位相同为0)就能直到。
     * => a^a=0, a^0=a
     * 2. perm[i]^perm[i+1] = encoded[i]
     * => perm[i+1] = perm[i]^encoded[i]
     * 所以只要求出perm[0],就可以得到后面的结果了。
     * <p>
     * 解题思路：look at here:
     * 因为
     * perm[0]^perm[1]=encoded[0]
     * perm[1]^perm[2]=encoded[1]
     * perm[2]^perm[3]=encoded[2]
     * perm[3]^perm[4]=encoded[3]
     * ...
     * 故有
     * perm[0]^perm[1]^perm[2]^perm[3]...^perm[n] =
     * perm[0]^encoded[1]^encoded[3]...^encoded[i] =
     * 1^2^3^...^n // i为奇数
     * 两边异或运算后：
     * perm[0] = 1^2^3^...^n^encoded[1]^encoded[3]...^encoded[i]
     */
    public static int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] perm = new int[n];
        // perm[0] = 1^2^3^...^n ^ encoded[1]^encoded[3]...^encoded[i] = a ^ b
        int a = 0, b = 0;

        for (int i = 1; i <= n; i++) {
            a ^= i;
        }
        for (int i = 1; i < encoded.length; i += 2) {
            b ^= encoded[i];
        }
        perm[0] = a ^ b;
        for (int i = 0; i < encoded.length; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }
        return perm;
    }
}
