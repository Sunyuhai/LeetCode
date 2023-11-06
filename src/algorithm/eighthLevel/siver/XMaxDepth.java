package algorithm.eighthLevel.siver;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：N叉数的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 */
public class XMaxDepth {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public static void main(String[] args) {
        // 没有示例
    }


    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> heoghts = new LinkedList<>();
            for (Node item : root.children) {
                heoghts.add(maxDepth(item));
            }
            return Collections.max(heoghts) + 1;
        }
    }
}
