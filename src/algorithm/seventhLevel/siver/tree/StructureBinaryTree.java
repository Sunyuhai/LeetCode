package algorithm.seventhLevel.siver.tree;

import java.util.LinkedList;
import java.util.Queue;


public class StructureBinaryTree {
    public static TreeNode buildTree(int[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < levelOrder.length) {
            TreeNode current = queue.poll();

            if (levelOrder[i] != -1) {
                current.left = new TreeNode(levelOrder[i]);
                queue.add(current.left);
            }
            i++;

            if (i < levelOrder.length && levelOrder[i] != -1) {
                current.right = new TreeNode(levelOrder[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}
