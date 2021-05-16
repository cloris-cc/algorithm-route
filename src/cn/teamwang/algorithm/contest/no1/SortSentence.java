package cn.teamwang.algorithm.contest.no1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class SortSentence {
    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }

    public static String sortSentence(String s) {
        StringBuilder res = new StringBuilder();
        String[] strs = s.split(" ");

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int n1 = o1.charAt(o1.length() - 1);
                int n2 = o2.charAt(o2.length() - 1);
                return Integer.compare(n1, n2);
            }
        });
//        for (int i = 0; i < strs.length; i++) {
//            // 获取数字位，并根据数字排序strs
//            int num = strs[i].charAt(strs[i].length() - 1);
//
//        }
        for (String str : strs) { // is2
            res.append(str.substring(0, str.length() - 1)).append(" ");
        }
        return res.toString().trim();
    }
}
