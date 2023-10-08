package algorithm.sixthLevel.siver;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * 示例 1:
 * 输入: root = [2,1,3]
 * 输出: 1
 */
public class FindBottomLeftValue {
    public static void main(String[] args) {
        TreeNode root = BinaryTreeBuilder.buildTree(new int[]{2, 1, 3});
        int result = findBottomLeftValue(root);
        System.out.println(result);
    }

    public static int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                result = poll.val;
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                if (poll.left != null){
                    queue.offer(poll.left);
                }
            }
        }
        return result;
    }
}
