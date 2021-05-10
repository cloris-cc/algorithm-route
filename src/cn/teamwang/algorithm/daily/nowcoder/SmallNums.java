package cn.teamwang.algorithm.daily.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class SmallNums {
    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(nums, 4));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        if (k > input.length) {
            return res;
        }
        for (int j : input) {
            list.add(j);
        }
        Collections.sort(list);
        for (int i = 0; i < k; i++) {
            res.add(list.get(i));
        }
        return res;
    }
}
