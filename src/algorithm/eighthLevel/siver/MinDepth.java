package algorithm.eighthLevel.siver;

import algorithm.eighthLevel.bronze.BinaryTreePrinter;
import algorithm.seventhLevel.siver.tree.StructureBinaryTree;
import algorithm.seventhLevel.siver.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 */
public class MinDepth {
    public static void main(String[] args) {
        TreeNode node = StructureBinaryTree.buildTree(new int[]{1, 2, 3, 4, 5});
        BinaryTreePrinter.printTree(node);
        System.out.println(minDepth(node));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return level;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return 0;
    }
}
