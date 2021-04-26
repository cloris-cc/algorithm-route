package cn.teamwang.algorithm.modest;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        System.out.println(test("We are happy."));
    }

    public static String test(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }

        return res.toString();

    }
}
