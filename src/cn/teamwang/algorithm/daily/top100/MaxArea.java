package cn.teamwang.algorithm.daily.top100;

/**
 * 11. 盛最多水的容器
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] t1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] t2 = {1, 1};
        int[] t3 = {4, 3, 2, 1, 4};
        int[] t4 = {1, 2, 1};
        System.out.println(maxArea(t1));
        System.out.println(maxArea(t2));
        System.out.println(maxArea(t3));
        System.out.println(maxArea(t4));
    }

    public static int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;

        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
