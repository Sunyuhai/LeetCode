package algorithm.sixthLevel.bronze;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeReconstruction {
    public static void main(String[] args) {
        BinaryTreeReconstruction builder = new BinaryTreeReconstruction();

        // 通过前序遍历和中序遍历序列重构二叉树
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode reconstructedTree1 = builder.buildTreeFromPreorderInorder(preorder, inorder);
        builder.inOrderTraversal(reconstructedTree1);
        System.out.println();

        // 通过中序遍历和后序遍历序列重构二叉树
        int[] inorder2 = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode reconstructedTree2 = builder.buildTreeFromInorderPostorder(inorder2, postorder);
        builder.inOrderTraversal(reconstructedTree2);
    }

    public TreeNode buildTreeFromPreorderInorder(int[] preorder, int[] inorder) {
        return buildTreeFromPreorderInorder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeFromPreorderInorder(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        int rootIndexInInorder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndexInInorder = i;
                break;
            }
        }

        int leftSubtreeSize = rootIndexInInorder - inStart;
        root.left = buildTreeFromPreorderInorder(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, rootIndexInInorder - 1);
        root.right = buildTreeFromPreorderInorder(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, rootIndexInInorder + 1, inEnd);

        return root;
    }

    public TreeNode buildTreeFromInorderPostorder(int[] inorder, int[] postorder) {
        return buildTreeFromInorderPostorder(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeFromInorderPostorder(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        int rootIndexInInorder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndexInInorder = i;
                break;
            }
        }

        int leftSubtreeSize = rootIndexInInorder - inStart;
        root.left = buildTreeFromInorderPostorder(inorder, inStart, rootIndexInInorder - 1, postorder, postStart, postStart + leftSubtreeSize - 1);
        root.right = buildTreeFromInorderPostorder(inorder, rootIndexInInorder + 1, inEnd, postorder, postStart + leftSubtreeSize, postEnd - 1);

        return root;
    }

    // 打印二叉树的中序遍历结果（用于验证重构后的二叉树）
    public void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }

}
