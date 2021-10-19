package cn.teamwang.algorithm.daily.offerII.medium;

import java.util.Arrays;

/**
 * 剑指 Offer II 014. 字符串中的变位词
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CheckInclusion {
    public static void main(String[] args) {
//        System.out.println(checkInclusion("ab", "eidbaooo"));
//        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("adc", "dcda"));
//        System.out.println(checkInclusion1("ab", "eidbaooo"));
//        System.out.println(checkInclusion1("ab", "eidboaoo"));
        System.out.println(checkInclusion1("adc", "dcda"));
    }

    /**
     * 超时
     */
    public static boolean checkInclusion(String s1, String s2) {
        // 子串计数器
        int[] freq = counter(s1);

        for (int i = 0; i < s2.length(); i++) {
            for (int j = i + 1; j <= s2.length(); j++) {
                if (Arrays.equals(freq, counter(s2.substring(i, j)))) {
                    return true;
                }

            }
        }
        return false;
    }

    private static int[] counter(String s) {
        int[] freq = new int[128];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        return freq;
    }

    /**
     * 固定大小的滑动窗口.l和r同时滑动。
     */
    public static boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        // freq2表示长度为s1的子字符串的计数器
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int l = 0, r = s1.length();

        // 顺便初始化窗口
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        // 判断第一个初始化窗口
        if (Arrays.equals(freq1, freq2)) {
            return true;
        }

        while (r < s2.length()) {
            // 再从第二个窗口开始
            freq2[s2.charAt(r) - 'a']++;
            freq2[s2.charAt(l) - 'a']--;
            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
            l++;
            r++;
        }
        return false;
    }

}
