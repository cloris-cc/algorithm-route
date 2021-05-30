package cn.teamwang.algorithm.contest.no3;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CountGoodSubstrings {
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz"));
        System.out.println(countGoodSubstrings("aababcabc"));
    }

    /**
     * @param s todo 3
     * @return
     */
    public static int countGoodSubstrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1)
                    && s.charAt(i) != s.charAt(i + 2)
                    && s.charAt(i + 1) != s.charAt(i + 2)) {
                res++;
            }
        }
        return res;
    }
}
