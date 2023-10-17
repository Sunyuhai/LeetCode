package algorithm.eighthLevel.bronze;


import algorithm.seventhLevel.siver.tree.StructureBinaryTree;
import algorithm.seventhLevel.siver.tree.TreeNode;

/**
 * 题目：对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 */
public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode node = StructureBinaryTree.buildTree(new int[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(isSymmetric(node));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}
