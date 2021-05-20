package cn.teamwang.algorithm.daily.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class TopKFrequent {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent1(words, 2));
        System.out.println(topKFrequent1(words2, 4));
    }

    /**
     * 对map的value排序
     */
    public static List<String> topKFrequent1(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new TreeMap<>();

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        // map转list再排序
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(((o1, o2) -> o2.getValue() - o1.getValue()));

        for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }

    public static List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        // 只放降序排序后的key值就好了
        List<String> list = new ArrayList<>(map.keySet());

        list.sort(((w1, w2) -> map.get(w1) == map.get(w2) ? w1.compareTo(w2) : map.get(w2) - map.get(w1)));
        return list.subList(0, k);
    }
}
