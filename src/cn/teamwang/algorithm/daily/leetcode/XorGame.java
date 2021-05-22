package cn.teamwang.algorithm.daily.leetcode;

/**
 * 810. 黑板异或游戏
 * <p>
 * 结论：奇数长度的数组，其异或结果一定不为0。偶数长度就不一定啦。
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class XorGame {
    public static void main(String[] args) {

    }

    // 对alice：
    // 擦掉数字后，剩下数的字异或结果为0失败。
    // 什么都不做，剩下的数字异或0胜利
    public static boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }
}
