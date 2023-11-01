package algorithm.eighthLevel.siver;

import algorithm.eighthLevel.bronze.BinaryTreePrinter;
import algorithm.seventhLevel.siver.tree.StructureBinaryTree;
import algorithm.seventhLevel.siver.tree.TreeNode;

/**
 * 题目：二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode node = StructureBinaryTree.buildTree(new int[]{3, 9, 20, -1, -1, 15, 7});
        int result = maxDepth(node);
        System.out.println(result);
        BinaryTreePrinter.printTree(node);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = maxDepth(root.left);
        int j = maxDepth(root.right);
        return Math.max(i, j) + 1;
    }
}
