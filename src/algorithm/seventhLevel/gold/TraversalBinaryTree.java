package algorithm.seventhLevel.gold;

import algorithm.seventhLevel.siver.tree.StructureBinaryTree;
import algorithm.seventhLevel.siver.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 迭代法，二叉树的前中后序遍历
 */
public class TraversalBinaryTree {
    public static void main(String[] args) {
        TreeNode root = StructureBinaryTree.buildTree(new int[]{1, 2, 3, 4, 5, -1, 6, -1, -1, 7});
        List<Integer> result1 = traversalBinaryTreePre(root);
        System.out.println("前序遍历:");
        for (int em : result1) {
            System.out.print(em + " ");
        }
        System.out.println();
        System.out.println("中序遍历:");
        List<Integer> result2 = traversalBinaryTreeInOrder(root);
        for (int em : result2) {
            System.out.print(em + " ");
        }
        System.out.println();
        System.out.println("后序遍历:");
        List<Integer> result3 = traversalBinaryTreePostorder(root);
        for (int em : result3) {
            System.out.print(em + " ");
        }
    }

    //前序遍历
    public static List<Integer> traversalBinaryTreePre(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            // 因为先打印左子树，然后右子树。
            // 所以Stack 先加入右子树，然后左子树。
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    //中序遍历
    public static List<Integer> traversalBinaryTreeInOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                cur = node.right;
            }
        }
        return result;
    }

    //后序遍历
    public static List<Integer> traversalBinaryTreePostorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        return result;
    }

    //后续遍历简单版
    public static List<Integer> traversalBinaryTreePostorder_2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
