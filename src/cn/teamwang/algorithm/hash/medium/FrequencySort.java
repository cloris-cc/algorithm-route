package cn.teamwang.algorithm.hash.medium;

import java.util.*;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }

    public static String frequencySort(String s) {
        StringBuilder res = new StringBuilder();
        // key:索引
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 按map的val排序
        List<Character> list = new ArrayList<>(map.keySet());
        // 倒序？
        list.sort(((o1, o2) -> map.get(o2).compareTo(map.get(o1))));
        for (Character c : list) {
            for (int i = 0; i < map.get(c); i++) {
                res.append(c);
            }
        }
        return res.toString();
    }
}
