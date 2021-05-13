package cn.teamwang.algorithm.dp;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CuttingRopeAdv {
    public static void main(String[] args) {
        System.out.println(cuttingRope1(2));
        System.out.println(cuttingRope1(10));
        System.out.println(cuttingRope1(120)); // 953271190
        System.out.println(cuttingRope2(120));
    }

    /**
     * 这一题已经不能用动态规划了。
     * 不是因为long会溢出，而是取余之后max函数就不能用来比大小了。
     */
    public static int cuttingRope1(int n) {
        int mod = 1000000007;
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

    public static int cuttingRope2(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int mod = 1000000007;
        long sum = 1;

        while (n > 4) {
            sum = (sum * 3) % mod;
            n -= 3;
        }
        return (int) ((sum * n) % mod);
    }
}
