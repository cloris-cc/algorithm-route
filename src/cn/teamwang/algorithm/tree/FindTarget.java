package cn.teamwang.algorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 653. 两数之和 IV - 输入 BST
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class FindTarget {
    public static void main(String[] args) {

    }

    /**
     * 二叉搜索树特点：有序(中序遍历) O(n)
     */
    public static boolean findTarget1(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        // 有序 二分查找/左右指针
        int l = 0, r = list.size() - 1; // list没有length只有s ize呀
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }

    /**
     * 避免穷举的哈希表：O(nlogn)
     */
    public static boolean findTarget2(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        inorder(root, list);

        for (int i = 0; i < list.size(); i++) {
            int target = k - list.get(i);
            if (map.containsKey(target)) {
                return true;
            }
            map.put(list.get(i), i);
        }
        return false;
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }


}
