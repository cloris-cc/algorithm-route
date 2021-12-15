package cn.teamwang.algorithm.daily.leetcode.easy;

/**
 * 28. 实现 strStr()
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("", ""));
        System.out.println(strStr("a", "a"));
    }

    /**
     * normal method
     */
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        // sub string 3
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i <= m - n; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
