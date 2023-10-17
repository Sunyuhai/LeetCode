package algorithm.eighthLevel.bronze;

import algorithm.seventhLevel.siver.tree.StructureBinaryTree;
import algorithm.seventhLevel.siver.tree.TreeNode;

/**
 * 题目：合并二叉树
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那
 * 么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。 给你两棵二叉树： root1 和 root2 。
 * 示例 1：
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 */
public class MergeTrees {
    public static void main(String[] args) {
        TreeNode node1 = StructureBinaryTree.buildTree(new int[]{1, 3, 2, 5});
        TreeNode node2 = StructureBinaryTree.buildTree(new int[]{2, 1, 3, -1, 4, -1, 7});
        TreeNode result = mergeTrees(node1, node2);
        BinaryTreePrinter.printTree(result);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        System.out.println(root1.val + ":" + root2.val);
        TreeNode mergeNode = new TreeNode(root1.val + root2.val);
        System.out.println(mergeNode.val);
        mergeNode.left = mergeTrees(root1.left, root2.left);
        mergeNode.right = mergeTrees(root1.right, root2.right);
        return mergeNode;
    }
}
