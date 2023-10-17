package algorithm.eighthLevel.bronze;


import algorithm.seventhLevel.siver.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 打印二叉树的形状
 */
public class BinaryTreePrinter {

    public static void printTree(TreeNode root) {
        int treeHeight = getHeight(root);
        printNodeInternal(Collections.singletonList(root), 1, treeHeight);
    }

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int treeHeight) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) {
            return;
        }

        int floor = treeHeight - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, treeHeight);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static boolean isAllElementsNull(List<TreeNode> list) {
        for (TreeNode node : list) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }
}

