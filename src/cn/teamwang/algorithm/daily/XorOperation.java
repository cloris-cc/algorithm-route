package cn.teamwang.algorithm.daily;

/**
 * 1486. 数组异或操作
 * e.g.
 * 若x是二进制数0101，y是二进制数1011
 * 则 x^y=1110
 * 即 相同为0，不同为1
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class XorOperation {
    public static void main(String[] args) {
        //System.out.println(0 ^ 2 ^ 4 ^ 6 ^ 8);
        //System.out.println(0^ 3 ^ 5 ^ 7 ^ 9);
        System.out.println(3^5);

        System.out.println(xorOperation(5,0));
        System.out.println(xorOperation(4,3));
        System.out.println(xorOperation(1, 7));
        System.out.println(xorOperation(10,5));
    }

    public static int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = start + 2 * i;
            res ^= nums[i];
        }
        return res;
    }
}
