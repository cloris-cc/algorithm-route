package cn.teamwang.algorithm.tree;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class LowestCommonAncestor {

    /**
     * 根据二叉搜索树的特性。中序遍历(左-根-右)的节点值为升序
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
