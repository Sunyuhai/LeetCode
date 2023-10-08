package algorithm.seventhLevel.siver;


import algorithm.seventhLevel.siver.tree.StructureBinaryTree;
import algorithm.seventhLevel.siver.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = StructureBinaryTree.buildTree(new int[]{1, -1, 2, 3});
        List<Integer> result = preorderTraversal(root);
        for (int em : result) {
            System.out.print(em + " ");
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    // 中序遍历和后序遍历类似相同
    public static void dfs(TreeNode head, List<Integer> result) {
        if (head == null) return;
        result.add(head.val);
        dfs(head.left, result);
        dfs(head.right, result);
    }
}
