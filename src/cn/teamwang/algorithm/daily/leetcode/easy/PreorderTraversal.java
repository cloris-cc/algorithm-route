package cn.teamwang.algorithm.daily.leetcode.easy;

import cn.teamwang.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class PreorderTraversal {
    public static void main(String[] args) {

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(res, root);
        return res;
    }

    private static void preorder(List<Integer> list, TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preorder(list, root.left);
            preorder(list, root.right);
        }
    }
}
