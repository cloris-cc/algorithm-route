package cn.teamwang.algorithm.tree;

import java.util.*;

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
     * 中序遍历: 二叉搜索树list为有序(升序)
     */
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }

    }

    /**
     * 迭代和栈实现
     */
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

    /**
     * 后序遍历
     */
    public void backorder(TreeNode root) {
        if (root != null) {
            backorder(root.left);
            backorder(root.right);
            System.out.println(root.val);
        }
    }

    /**
     * 层次遍历：
     * 1. 使用BFS(Breadth First Search)算法(队列)
     * 2.
     */
    public List<Integer> bfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        // similar to add()
        q.offer(root); // 第一层
        while (!q.isEmpty()) {
            // similar to remove()
            TreeNode node = q.poll();
            // business code
            list.add(node.val); // 第一层
            if (node.left != null) {
                q.offer(node.left); // 下一层
            }
            if (node.right != null) {
                q.offer(node.right); // 下一层
            }
        }
        return list;
    }

}
