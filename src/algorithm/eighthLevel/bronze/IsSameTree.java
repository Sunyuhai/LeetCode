package algorithm.eighthLevel.bronze;

import algorithm.seventhLevel.siver.tree.StructureBinaryTree;
import algorithm.seventhLevel.siver.tree.TreeNode;

/**
 * 题目：相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例 1：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 */
public class IsSameTree {
    public static void main(String[] args) {
        TreeNode node1 = StructureBinaryTree.buildTree(new int[]{1, 2});
        TreeNode node2 = StructureBinaryTree.buildTree(new int[]{1, -1, 2});
        boolean sameTree = isSameTree(node1, node2);
        System.out.println(sameTree);
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
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
