package cn.teamwang.algorithm.contest.no1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class SortSentence {
    public static void main(String[] args) {
        System.out.println(sortSentence1("is2 sentence4 This1 a3"));
        System.out.println(sortSentence2("is2 sentence4 This1 a3"));
    }

    /**
     * 时间复杂度：O(nlogn+n)=O(nlogn)
     */
    public static String sortSentence1(String s) {
        StringBuilder res = new StringBuilder();
        String[] strs = s.split(" ");

        Arrays.sort(strs, (o1, o2) -> {
            int n1 = o1.charAt(o1.length() - 1);
            int n2 = o2.charAt(o2.length() - 1);
            return Integer.compare(n1, n2);
        });
        // 拼接排序后的单词
        for (String str : strs) {
            res.append(str, 0, str.length() - 1).append(" ");
        }
        // 去末尾空格
        return res.toString().trim();
    }

    /**
     * 时间复杂度O(n)
     */
    public static String sortSentence2(String s) {
        String[] strs = s.split(" ");
        String[] res = new String[strs.length];

        for (String str : strs) {
            // 把数字字符('0'~'9')当做下标
            int num = str.charAt(str.length() - 1) - '0' - 1;
            // 保存单词
            res[num] = str.substring(0, str.length() - 1);
        }
        return String.join(" ", res);
    }
}
