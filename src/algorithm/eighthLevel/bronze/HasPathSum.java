package algorithm.eighthLevel.bronze;

import algorithm.seventhLevel.siver.tree.StructureBinaryTree;
import algorithm.seventhLevel.siver.tree.TreeNode;

/**
 * 题目：路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
 * targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 */
public class HasPathSum {
    public static void main(String[] args) {
        TreeNode node = StructureBinaryTree.buildTree(new int[]{5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, 1});
        boolean flag = hasPathSum(node, 22);
        System.out.println(flag);
        BinaryTreePrinter.printTree(node);
    }


    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        return left || right;
    }
}
