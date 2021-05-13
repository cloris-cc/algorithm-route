package cn.teamwang.algorithm.dp;

/**
 * 剑指 Offer 14- I. 剪绳子
 * <p>
 * 思路：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/dong-tai-gui-hua-jie-fa-zui-xi-zhi-jie-x-ilyh/
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CuttingRope {
    public static void main(String[] args) {
        System.out.println(cuttingRope1(2));
        System.out.println(cuttingRope2(2));
        System.out.println(cuttingRope1(10));
        System.out.println(cuttingRope2(10));
    }

    /**
     * 1. dp[i]表示 绳长i剪成若干段后的 乘积。
     * 2. 初始值。i>1, 故初始值dp[2]=1。dp[0]dp[1]默认0
     * 3. 对于dp[i]，剪掉一段长为j的绳子后剩下长度为(i-j)。j<i
     * c1: (i-j)不剪：dp[i] = j*(i-j)
     * c2: (i-j)继续剪：dp[i] = j*dp[i-j]
     * 上面两种情况不相加是因为结果是要求出最大值，因此dp[i]=max(c1,c2)
     */
    public static int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int t = Math.max(j * (i - j), j * dp[i - j]);
                // 因为要求最大值，加上dp[i]原本也有初始值0，所以一起比较。(只能这么勉强地解释了)
                dp[i] = Math.max(dp[i], t);
            }
        }
        return dp[n];
    }

    /**
     * 通过推导 均值不等式，得出结论乘以因数3后的结果最大。
     */
    public static int cuttingRope2(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int sum = 1;

        while (n > 4) {
            sum *= 3;
            n -= 3;
        }
        return sum * n;
    }
}
