package cn.teamwang.algorithm.daily.paper.bilibili;

/**
 * https://www.nowcoder.com/question/next?pid=30020877&qid=1555160&tid=44866607
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class GetFragment {
    public static void main(String[] args) {
        System.out.println(GetFragment("aaabbaaac"));
    }

    public static int GetFragment(String str) {
        int cnt = 1;
        for (int i = 0; i < str.toCharArray().length - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                cnt++;
            }
        }
        return str.length() / cnt;
    }
}
