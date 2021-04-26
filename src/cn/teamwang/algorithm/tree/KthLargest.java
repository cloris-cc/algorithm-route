package cn.teamwang.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class KthLargest {

    List<Integer> list = new ArrayList<>();

    /**
     * 转换为有序数组
     */
    public int kthLargest(TreeNode root, int k) {
        inorder(root);
        return (int) list.toArray()[list.size() - k];
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
}
