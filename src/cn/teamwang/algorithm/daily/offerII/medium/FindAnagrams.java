package cn.teamwang.algorithm.daily.offerII.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 015. 字符串中的所有变位词
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class FindAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    /**
     * 固定大小的滑动窗口
     */
    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();

        int[] freq_p = new int[26]; // short
        int[] freq_s = new int[26]; // long

        for (int i = 0; i < p.length(); i++) {
            freq_p[p.charAt(i) - 'a']++;
            freq_s[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(freq_p, freq_s)) {
            res.add(0);
        }

        int l = 0, r = p.length();
        while (r < s.length()) {
            freq_s[s.charAt(l) - 'a']--;
            freq_s[s.charAt(r) - 'a']++;
            if (Arrays.equals(freq_p, freq_s)) {
                res.add(l + 1);
            }
            l++;
            r++;
        }
        return res;
    }
}
