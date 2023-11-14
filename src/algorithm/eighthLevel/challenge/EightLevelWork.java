package algorithm.eighthLevel.challenge;


import algorithm.eighthLevel.bronze.BinaryTreePrinter;
import algorithm.seventhLevel.siver.tree.StructureBinaryTree;
import algorithm.seventhLevel.siver.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除所有的叶子节点
 */
public class EightLevelWork {
    public static void main(String[] args) {
        TreeNode node = StructureBinaryTree.buildTree(new int[]{3, 9, 20, 11, -1, 15, 7, -1, -1, 2, 4, 6, 8});
        BinaryTreePrinter.printTree(node);
        deleteNode(node);
        BinaryTreePrinter.printTree(node);
        // 根节点到叶子节点所有路径
        ArrayList<String> pathList = new ArrayList<>();
        getdfs(node,"", pathList);
        for (String path : pathList) {
            System.out.println(path);
        }
    }

    public static void deleteNode(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                root.left = null;

            }
        }

        if (root.right != null) {
            if (root.right.right == null && root.right.left == null) {
                root.right = null;

            }
        }
        deleteNode(root.left);
        deleteNode(root.right);
    }

    public static void getdfs(TreeNode root, String path, List<String> pathList) {
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            pathList.add(path);
        }
        path += "->";

        getdfs(root.left, path, pathList);
        getdfs(root.right, path, pathList);
    }


}