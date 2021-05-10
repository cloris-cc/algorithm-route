package cn.teamwang.algorithm.slidingwindow;

import cn.teamwang.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LeafSimilar {
    public static void main(String[] args) {
        // 示例 1
        // root1 & root2 67498
        // 中序遍历：6 5 7 2 4 3 9 1 8 ｜ 6 5 7 3 4 1 9 2 8
        // 先序遍历：3 5 6 2 7 4 1 9 8 ｜ 3 5 6 7 1 4 2 9 8
        // 后序遍历：
        // 示例 5
        // root 1 & root2 23 32
        // 中序遍历：2 1 3 ｜ 3 1 2
        // 示例 4
        // root1 & root2 2
        // 中序遍历：2 1 ｜ 2 2

    }


    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    public static void dfs(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            if (root.left != null) {
                dfs(root.left, list);
            }
            if (root.right != null) {
                dfs(root.right, list);
            }
        }
    }
}
