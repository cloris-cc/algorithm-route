package cn.teamwang.algorithm.modest;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CommonPrefix {
    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        String[] strs3 = {"cir", "car"};

        System.out.println(test2(strs1));
        System.out.println(test1(strs2));
        System.out.println(test1(strs3));

        System.out.println("".length());

    }

    public static String test1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 1. 遍历最短字符串
        int minLength = strs[0].length();
        int index = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
                index = i;
            }
        }
        char[] c = strs[index].toCharArray(); // flow
        StringBuilder res = new StringBuilder();

        labelA:
        for (int i = 0; i < minLength; i++) {
            int count = 0;

            for (String str : strs) {
                // 字符重复出现的次数

                if (c[i] == str.toCharArray()[i]) {
                    count++;
                    if (count == strs.length) {
                        res.append(c[i]);
                    }
                } else {
                    break labelA;
                }
            }
        }
        return res.toString();
    }

    public static String test2(String[] strs) {
        // 事实上，公共前缀必 < or = 任意字符串
        String s = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(s)) { // "abc" 3
                s = s.substring(0, s.length() - 1);
                if (s.length() == 0) {
                    return "";
                }
            }

        }
        return s;
    }
}
