package cn.teamwang.algorithm.tree;

/**
 * 剑指 Offer 27. 二叉树的镜像
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class MirrorTree {
    public static void main(String[] args) {

    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode t = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(t);
        return root;
    }
}
