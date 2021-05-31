package cn.teamwang.algorithm.contest.no2;

/**
 * todo 中等dp/dfs 1871. 跳跃游戏 VII
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CanReach {
    public static void main(String[] args) {
//        System.out.println(canReach("011010", 2, 3));
//        System.out.println(canReach("01101110", 2, 3));
//        System.out.println(canReach("011101101110", 3, 4));
        System.out.println(canReach("0000000000", 8, 8));
        System.out.println(canReach("00", 1, 1));
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) == '1') {
            return false;
        }
        // min-1 <= len(111..) <= max-1
        // 求出子串全1的最小，最大长度即可。& 全部0
        int minLen = Integer.MAX_VALUE; // todo
        int maxLen = Integer.MIN_VALUE;

        int len = 0;
        int flag = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                len++;
            } else {
                // 遇到0了
                if (len != 0) {
                    minLen = Math.min(minLen, len);
                    maxLen = Math.max(maxLen, len);
                }
                flag++;
                len = 0;
            }
        }
        System.out.println("minLen: " + minLen);
        System.out.println("maxLen: " + maxLen);
        //00 1
        if (flag == s.length() && minJump == maxJump && s.length() > minJump) {
            return true;
        }

        if (minJump - 1 > minLen || maxLen > maxJump - 1
                || minLen == Integer.MAX_VALUE || maxLen == Integer.MIN_VALUE) {
            return false;
        } else {
            return true;
        }
    }

}
