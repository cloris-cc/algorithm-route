package cn.teamwang.algorithm.tree;

/**
 * todo review 剑指 Offer 68 - II. 二叉树的最近公共祖先
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class lowestCommonAncestorAdv {
    /**
     * (通用解)
     * 1. p q 一个在左子树 一个在右子树 那么当前节点即是最近公共祖先
     * 2. p q 都在左子树
     * 3. p q 都在右子树
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            // p q 一个在左，一个在右
            return root;
        }
        if (left != null) {
            // p q 都在左子树
            return left;
        }
        if (right != null) {
            // p q 都在右子树
            return right;
        }
        return null;
    }
}
