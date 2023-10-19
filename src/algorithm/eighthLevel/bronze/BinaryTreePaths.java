package algorithm.eighthLevel.bronze;

import algorithm.seventhLevel.siver.tree.StructureBinaryTree;
import algorithm.seventhLevel.siver.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode node = StructureBinaryTree.buildTree(new int[]{1, 2, 3, -1, 5});
        List<String> result = binaryTreePaths(node);
        for (String em : result) {
            System.out.print(result + " ");
        }
        System.out.println();
        BinaryTreePrinter.printTree(node);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(root, path, result);
        return result;
    }

    public static void dfs(TreeNode root, List<String> path, List<String> result) {
        path.add(root.val + "");
        if (root.left == null && root.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                stringBuilder.append(path.get(i)).append("->");
            }
            stringBuilder.append(path.get(path.size() - 1));
            result.add(stringBuilder.toString());
            return;
        }
        if (root.left != null) {
            dfs(root.left, path, result);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, path, result);
            path.remove(path.size() - 1);
        }
    }
}
