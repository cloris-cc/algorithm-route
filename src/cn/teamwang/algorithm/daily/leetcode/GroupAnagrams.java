package cn.teamwang.algorithm.daily.leetcode;

import java.util.*;

/**
 * 面试题 10.02. 变位词组
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(test));
    }

    /**
     * 对每个单词进行排序，最后再遍历
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (String str : strs) {
            char[] w = str.toCharArray();
            Arrays.sort(w);
            String s = Arrays.toString(w);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}
