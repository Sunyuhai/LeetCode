package algorithm.sixthLevel.siver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode root = BinaryTreeBuilder.buildTree(new int[]{3, 9, 20, -1, -1, 15, 7});
        List<List<Integer>> lists = zigzagLevelOrder(root);
        for(List e : lists){
            System.out.println(e);
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int flag = 0;
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            flag++;
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (flag % 2 == 0){
                    list.add(0,poll.val);
                }else {
                    list.add(poll.val);
                }
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
