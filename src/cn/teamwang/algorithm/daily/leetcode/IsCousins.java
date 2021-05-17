package cn.teamwang.algorithm.daily.leetcode;

import cn.teamwang.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 993. 二叉树的堂兄弟节点
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class IsCousins {
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, null, n5);
        TreeNode n2 = new TreeNode(2, null, n4);
        TreeNode n1 = new TreeNode(1, n2, n3);
//        System.out.println(bfs(n1));
        System.out.println(isCousins(n1, 5, 4));
    }

    static int xPar, xDep, yPar, yDep;

    public static boolean isCousins(TreeNode root, int x, int y) {
        dfs(root.left, 1, x, y, root.val);
        dfs(root.right, 1, x, y, root.val);
        return (xPar != yPar) && (xDep == yDep);
    }

    /**
     * todo
     */
    public static void dfs(TreeNode node, int dep, int x, int y, int par) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            xPar = par;
            xDep = dep;
        } else if (node.val == y) {
            yPar = par;
            yDep = dep;
        } else {
            dfs(node.left, dep + 1, x, y, node.val);
            dfs(node.right, dep + 1, x, y, node.val);
        }
    }

    /**
     * error
     * 同个深度为一个list。
     * 没有节点为null，list长度为偶数，成对紧邻说明为同个父亲
     */
    public static List<Integer> bfs(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root); // 第一层
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) { // 下一层
                    q.offer(node.left);
                } else {
                    list.add(null);
                }
                if (node.right != null) { // 下一层
                    q.offer(node.right);
                } else {
                    list.add(null);
                }
                size--;
            }
        }
        return list;
    }
}
