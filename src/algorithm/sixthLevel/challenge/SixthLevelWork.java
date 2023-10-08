package algorithm.sixthLevel.challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SixthLevelWork {
    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{1, 2, 3, -1, 5, -1, 4});
        List<Integer> result = leftSideView(root);
        for (int em : result) {
            System.out.print(em + " ");
        }
    }

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

    public static List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int value = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                value = poll.val;
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                if (poll.left != null){
                    queue.offer(poll.left);
                }
            }
            result.add(value);
        }
        return result;
    }
}
