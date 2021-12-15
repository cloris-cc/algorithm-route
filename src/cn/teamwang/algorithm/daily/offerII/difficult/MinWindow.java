package cn.teamwang.algorithm.daily.offerII.difficult;

/**
 * 剑指 Offer II 017. 含有所有字符的最短字符串
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MinWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }

    /**
     * 穷举 + 优化condition
     */
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        String res = "";
        int[] freq_t = counter(t);
        int len = Integer.MAX_VALUE;

        // freq_t - freq_sub 后没有全部为0
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + t.length(); j <= s.length(); j++) {
                String sub = s.substring(i, j);
                int[] freq_sub = counter(sub);
                if (check(freq_t, freq_sub)) { // 成立
                    if (sub.length() < len) {
                        len = sub.length();
                        res = sub;
                    }
                }

            }
        }
        return res;
    }

    private static boolean check(int[] freq_t, int[] freq_sub) {
        for (int i = 0; i < freq_t.length; i++) {
            if (freq_t[i] - freq_sub[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private static int[] counter(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        return freq;
    }
}
