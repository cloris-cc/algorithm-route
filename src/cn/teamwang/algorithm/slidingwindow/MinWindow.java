package cn.teamwang.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MinWindow {
    public static void main(String[] args) {
        System.out.println(minWindow1("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow1("a", "a"));
        System.out.println(minWindow1("a", "aa"));
        System.out.println(minWindow1("bbaa", "aba"));
        System.out.println(minWindow1("aaaaaaaaaaaabbbbbcdd", "abcdd"));
        System.out.println(minWindow1("a", "b"));
        System.out.println();
        System.out.println(minWindow2("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow2("a", "a"));
        System.out.println(minWindow2("a", "aa"));
        System.out.println(minWindow2("bbaa", "aba"));
        System.out.println(minWindow2("aaaaaaaaaaaabbbbbcdd", "abcdd"));
        System.out.println(minWindow1("a", "b"));

    }
    /*
        // 用list保存字符就无法保证正确的字符个数了。例如对于"bbaa" "aba"，预期结果为"baa"，而使用list会变成"bba"。
        // list("a").containAll(list("aa")) = true
        List<Character> sList = new ArrayList<>();
        List<Character> tList = new ArrayList<>();
     */

    /**
     * 优化的穷举法，依然timeout
     */
    public static String minWindow1(String s, String t) {
        String res = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + t.length() - 1; j < s.length(); j++) {
                if (check(s.substring(i, j + 1), t)) {
                    int len = s.substring(i, j + 1).length();
                    if (len < minLen) {
                        res = s.substring(i, j + 1);
                        minLen = len;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 不用 map 计数，因为一直new Integer会导致最后一个测试用例超时过不了。
     */
    private static boolean check(String s, String t) {
//        Map<Character, Integer> map1 = new HashMap<>();
//        Map<Character, Integer> map2 = new HashMap<>();
        int[] freq1 = new int[128]; // ascii 码有 127 个
        int[] freq2 = new int[128];

        for (char c : s.toCharArray()) {
            freq1[c]++;
        }
        for (char c : t.toCharArray()) {
            freq2[c]++;
        }

        for (int i = 0; i < freq2.length; i++) {
            if (freq2[i] != 0 && freq2[i] > freq1[i]) {
                return false;
            }
        }
//        for (char c : s.toCharArray()) {
//            map1.put(c, map1.getOrDefault(c, 0) + 1);
//        }
//        for (char c : t.toCharArray()) {
//            map2.put(c, map2.getOrDefault(c, 0) + 1);
//        }
//
//        for (Character c : map2.keySet()) {
//            if (map2.get(c) > map1.getOrDefault(c, 0)) {
//                return false;
//            }
//        }
        return true;
    }

    public static String minWindow2(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int begin = 0;
        int minLen = Integer.MAX_VALUE;
        int l = 0, r = 0;

        // [l,r), 和substring方法的范围一样
        while (l < s.length() && r <= s.length()) {
            if (r - l < t.length()) { // 子串长度
                r = t.length() + l - 1;
            }
            if (!check(s.substring(l, r), t)) {
                // 不行
                r++;
            } else {
                // 行了
                while (l <= r && check(s.substring(l, r), t)) {
                    if (s.substring(l, r).length() < minLen) {
                        begin = l;
                        minLen = s.substring(l, r).length();
//                        System.out.println("begin:" + begin + " minLen:" + minLen);
                    }
                    l++;
                    if (r - l < t.length()) { // 子串长度
                        r = t.length() + l - 1;
                    }
                }
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(begin, begin + minLen);
    }
}
