package algorithm.eighthLevel.siver;

import algorithm.eighthLevel.bronze.BinaryTreePrinter;
import algorithm.seventhLevel.siver.tree.StructureBinaryTree;
import algorithm.seventhLevel.siver.tree.TreeNode;

/**
 * 题目：平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 */
public class IsBalanced {
    public static void main(String[] args) {
        TreeNode node = StructureBinaryTree.buildTree(new int[]{1, 2, 2, 3, 3, -1, -1, 4, 4});
        BinaryTreePrinter.printTree(node);
        System.out.println(isBalanced(node));
    }

    public static boolean isBalanced(TreeNode root) {
        return dfs(root) == -1 ? false : true;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfs(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfs(root.right);
        if (rightHeight == -1) return -1;
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;
    }
}
