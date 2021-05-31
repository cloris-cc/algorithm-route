package cn.teamwang.algorithm.contest.no4;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class IsSumEqual {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("021"));
        System.out.println(isSumEqual("acb", "cba", "cdb"));
    }

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        String num1 = "", num2 = "", num3 = "";
        for (char c : firstWord.toCharArray()) {
            num1 += c - 'a';
        }
        for (char c : secondWord.toCharArray()) {
            num2 += c - 'a';
        }
        for (char c : targetWord.toCharArray()) {
            num3 += c - 'a';
        }
        return Integer.parseInt(num1) + Integer.parseInt(num2) == Integer.parseInt(num3);
    }
}
