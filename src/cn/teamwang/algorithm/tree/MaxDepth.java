package cn.teamwang.algorithm.tree;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MaxDepth {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int nLeft = maxDepth(root.left);
        int nRight = maxDepth(root.right);
        return nLeft > nRight ? nLeft + 1 : nRight + 1;
    }
}
