package cn.teamwang.algorithm.tree;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftDepth - rightDepth) <= 1;

    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
