package cn.teamwang.algorithm.daily.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. 查找常用字符
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CommonChars {
    public static void main(String[] args) {
        /*
         * [1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
         * [1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
         * [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0]
         */
        String[] test1 = {"bella", "label", "roller"};
        /*
         * [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
         * [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
         * [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
         */
        String[] test2 = {"cool", "lock", "cook"};
        System.out.println(commonChars(test1));
        System.out.println(commonChars(test2));
    }

    public static List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        int[][] freq = new int[words.length][26];

        // 计算每行字符串26个字母出现次数
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                freq[i][c - 'a']++;
            }
        }
        for (int j = 0; j < 26; j++) {
            // 最少次数
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < freq.length; i++) { // 遍历每一行
                min = Math.min(min, freq[i][j]);
            }
            for (int i = 0; i < min; i++) {
                res.add(String.valueOf((char) (j + 'a')));
            }
        }
        return res;
    }
}
