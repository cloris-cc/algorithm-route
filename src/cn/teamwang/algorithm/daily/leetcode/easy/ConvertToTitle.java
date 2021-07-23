package cn.teamwang.algorithm.daily.leetcode.easy;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class ConvertToTitle {
    public static void main(String[] args) {
//        System.out.println(convertToTitle(1));
//        System.out.println(convertToTitle(28));
//        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(27));
    }

    /**
     * A & Z
     */
    public static String convertToTitle(int columnNumber) {
        // A~Z：1-26
        // AA~AZ: 27-52 BA～BZ：53+25=78
        // 26*26*26
        StringBuilder sb = new StringBuilder();

        while (columnNumber != 0) {
            int mod = columnNumber % 26;
            columnNumber /= 26;

            if (mod == 0) {
                sb.append('Z');
                columnNumber--;
            } else {
                sb.append((char)('A' + mod - 1));
            }
        }
        return sb.reverse().toString();
    }
}
