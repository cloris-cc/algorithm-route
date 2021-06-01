package cn.teamwang.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * todo 我吐了，明天再优化。应该是滑动的次数太多了。
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MinWindowCopy {
    Map<Character, Integer> map1 = new HashMap<Character, Integer>();
    Map<Character, Integer> map2 = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();

        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();

        while (r < sLen) {
            ++r;
            if (r < sLen && map1.containsKey(s.charAt(r))) {
                map2.put(s.charAt(r), map2.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (map1.containsKey(s.charAt(l))) {
                    map2.put(s.charAt(l), map2.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = map1.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (map2.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

}
