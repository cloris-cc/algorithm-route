package cn.teamwang.algorithm.dp.medium;

/**
 * 647. 回文子串
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CountSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }

    /**
     * 穷举O(n^3)
     * dp[i][j] 表示子串[i:j]是否为回文串. i<=j
     * dp[0][0]=true
     * dp[i][j]=dp[i+1][j-1], s[i]==s[j]
     */
    public static int countSubstrings(String s) {
        int res = 0;
        int m = s.length();
        boolean[][] dp = new boolean[m][m];
/*
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            dp[i][i] = true;
        }
*/
        for (int i = m - 1; i >= 0; i--) { // 因为要先求dp[i+1],所以外层循环倒着写
            for (int j = i; j < m; j++) {
                if (s.charAt(i) == s.charAt(j)) { // 当元素个数为1，2，3时，一定为回文串
                    dp[i][j] = j - i <= 2 ? true : dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        res++;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
/*        for (boolean[] d : dp) {
            for (boolean flag : d) {
                if (flag) {
                    res++;
                }
            }
        }*/
        return res;
    }
}
