package cn.teamwang.algorithm.daily.leetcode.easy;

import java.util.Arrays;

/**
 * 58. 最后一个单词的长度
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String test1 = "Hello World";
        String test2 = "   fly me   to   the moon  ";
        String test3 = "luffy is still joyboy";
        String test4 = "a";
        System.out.println(lengthOfLastWord(test1));
        System.out.println(lengthOfLastWord(test2));
        System.out.println(lengthOfLastWord(test3));
        System.out.println(lengthOfLastWord(test4));
    }

    public static int lengthOfLastWord(String s) {
        int res = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                while (i >= 0 && s.charAt(i) != ' ') {
                    res++;
                    i--;
                }
                return res;
            }
        }
        return res;
    }
}
