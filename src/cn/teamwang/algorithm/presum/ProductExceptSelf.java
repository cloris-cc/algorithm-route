package cn.teamwang.algorithm.presum;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf1(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        // calculate prefix and suffix
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];

        L[0] = 1;
        R[nums.length - 1] = 1;
        for (int i = 1; i < L.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int i = R.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }

    /**
     * decrease spatial complexity
     * the res for L; Int variable for R
     */
    public static int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];

        // L
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // R
        int R = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] *= R;
            R *= nums[i];
        }

        return res;
    }
}
