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
     * stack
     */
    public void preorder2(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            System.out.println(node.val);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
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
        if (root != null) { // 终止条件相当于 root==null return
            backorder(root.left);
            backorder(root.right);
            System.out.println(root.val);
        }
    }

    /**
     * 层次遍历相关算法：
     * 1. 使用BFS(Breadth First Search,广度优先搜索)算法(队列)
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

    /**
     * DFS: 直到 null 停止
     * <p>
     * 树3种遍历的基础算法：
     * Depth First Search，深度优先搜索
     * 可以用来搜索叶子节点(即没有左右节点的节点)
     */
    public List<Integer> dfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // 同时处理了左右节点的情况。
        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            if (root.left != null) {
                dfs(root.left);
            }
            if (root.right != null) {
                dfs(root.right);
            }
        }
        return list;
    }

}
