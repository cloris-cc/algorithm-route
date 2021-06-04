package cn.teamwang.algorithm.hash.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram1("anagram", "nagaram"));
        System.out.println(isAnagram1("rat", "car"));

        System.out.println(isAnagram2("anagram", "nagaram"));
        System.out.println(isAnagram2("rat", "car"));

    }

    /**
     * O(n^2)
     */
    public static boolean isAnagram1(String s, String t) {
        if (t.length() > s.length()) {
            return false;
        }
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        for (char c : t.toCharArray()) {
            if (list.contains(c)) { // contains方法O(n)
                list.remove((Object) c);
            }
        }
        return list.isEmpty();
    }

    /**
     * O(nlogn)
     */
    public static boolean isAnagram2(String s, String t) {
        if (t.length() != s.length()) {
            return false;
        }//继续考虑长度，遍历可能更惨的c1
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;

    }

    /**
     * O(n)
     */
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
