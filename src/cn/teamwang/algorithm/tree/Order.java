package cn.teamwang.algorithm.tree;

import java.util.Stack;

/**
 * 3 种遍历
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Order {

    /**
     * 先序遍历
     */
    public void preorder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
        }

    }

    /**
     * 中序遍历: list为升序
     */
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }

    }

    //2.2迭代和栈实现
    public void inorder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    public void backorder(TreeNode root) {
        if (root != null) {
            backorder(root.left);
            backorder(root.right);
            System.out.println(root.val);
        }
    }
}
