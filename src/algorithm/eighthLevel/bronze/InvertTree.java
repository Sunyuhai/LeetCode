package algorithm.eighthLevel.bronze;

import algorithm.seventhLevel.siver.tree.StructureBinaryTree;
import algorithm.seventhLevel.siver.tree.TreeNode;

/**
 * 题目: 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class InvertTree {
    public static void main(String[] args) {
        TreeNode node = StructureBinaryTree.buildTree(new int[]{4, 2, 7, 1, 3, 6, 9});
        BinaryTreePrinter.printTree(node);
        TreeNode result = invertTree(node);
        BinaryTreePrinter.printTree(result);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
