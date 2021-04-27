package cn.teamwang.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * todo 剑指 Offer 28. 对称的二叉树
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        isSymmetric2(n1);

        TreeNode nn1 = new TreeNode(1);
        TreeNode nn2 = new TreeNode(2);
        TreeNode nn3 = new TreeNode(2);
        TreeNode nn4 = new TreeNode(3);
        TreeNode nn5 = new TreeNode(3);

        nn1.left = nn2;
        nn1.right = nn3;
        nn2.right = nn4;
        nn3.right = nn5;

        isSymmetric2(nn1);

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(2);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;

        isSymmetric2(a);

    }


    /**
     * 用层次遍历(bfs算法)来判断是否对称
     * 空的话放个0？
     */
    public static boolean isSymmetric1(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }

    public static boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return root1.val == root2.val && helper(root1.left, root2.right) &&
                helper(root1.right, root2.left);
    }


    /**
     * ERROR
     * <p>
     * 先序遍历：1234243
     * *中序遍历：3241423
     * 后序遍历：3424321
     * <p>
     * 先序遍历：12323
     * 中序遍历：23123
     * 后序遍历：32321
     */
    public static boolean isSymmetric2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        System.out.println(list);
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public static void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        } else {
            list.add(0);
        }

    }
}
