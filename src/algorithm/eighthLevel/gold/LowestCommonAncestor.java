package algorithm.eighthLevel.gold;

import algorithm.seventhLevel.siver.tree.StructureBinaryTree;
import algorithm.seventhLevel.siver.tree.TreeNode;

import java.util.Stack;

/**
 * 题目：二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode node = StructureBinaryTree.buildTree(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
        TreeNode p = StructureBinaryTree.buildTree(new int[]{5, 6, 2, -1, -1, 7, 4});
        TreeNode q = StructureBinaryTree.buildTree(new int[]{1, 0, 8});
        TreeNode result = lowestCommonAncestor(node, p, q);
        System.out.println(result.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        System.out.println(root.val + ":" + p.val);
        System.out.println(root + ":" + p);
        // p 为当前树的根节点
        if(p == root) return p;
        // q 为当前树的根节点
        if(q == root) return q;

        // 去左子树中找
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        // 去右子树中找
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        // 左边右边都找到了
        if(left != null && right != null) {
            return root;
        }
        // 左边找到了，右边没找到
        if(left != null) {
            return left;
        }
        if(right != null) {
            return right;
        }
        return null;
    }

    public static TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        Stack<TreeNode> stackp = new Stack<>();
        Stack<TreeNode> stackq = new Stack<>();

        // 分别得到  p q 的路径
        getPath(root,p,stackp);
        getPath(root,q,stackq);

        int sizep = stackp.size();
        int sizeq = stackq.size();

        if(sizep > sizeq) {
            int size = sizep - sizeq;
            // 弹出元素直至两栈中元素个数相等
            while(size > 0) {
                stackp.pop();
                size--;
            }
        }else {
            int size = sizeq - sizep;
            // 弹出元素直至两栈中元素个数相等
            while(size > 0) {
                stackq.pop();
                size--;
            }
        }

        // 一起弹出，直到找到第一个相同的元素
        while(!stackp.isEmpty() && !stackq.isEmpty()) {
            if(stackp.peek() == stackq.peek()) {
                // 找到了，就返回该节点
                return stackq.pop();
            }else {
                stackp.pop();
                stackq.pop();
            }
        }
        // 没找到，返回 null
        return null;
    }

    // 用于找节点的路径
    public static boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if(root == null || node == null) {
            return false;
        }
        // 将当前节点放入栈中
        stack.push(root);

        if(root.val == node.val) {
            return true;// 找到了
        }
        // 当前节点没找到，去左子树找
        boolean flag = getPath(root.left,node,stack);
        // 左子树中找到了，直接返回
        if(flag) {
            return true;
        }
        // 左子树没找到，去右子树找
        flag = getPath(root.right,node,stack);
        // 右子树中找到了，直接返回
        if(flag) {
            return true;
        }

        // 左右子树都没找到，弹出节点
        stack.pop();
        return false;

    }

}
