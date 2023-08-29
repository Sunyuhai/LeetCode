package algorithm.firstLevel.siver;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;

import java.util.HashSet;

/**
 * 题目：两个链表第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，
 *          链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */
public class FindFirstCommonNode {
    public static void main(String[] args) {
        // listA 链表数据
        ListNode listA1 = new ListNode(4);
        ListNode listA2 = new ListNode(1);
        // listB 链表数据
        ListNode listB1 = new ListNode(5);
        ListNode listB2 = new ListNode(0);
        ListNode listB3 = new ListNode(1);
        // listA 和 listB 相交节点
        ListNode listAB1 = new ListNode(8);
        ListNode listAB2 = new ListNode(4);
        ListNode listAB3 = new ListNode(5);

        SingleListedList headAB = new SingleListedList();
        headAB.addNodeEnd(listAB1);
        headAB.addNodeEnd(listAB2);
        headAB.addNodeEnd(listAB3);

        SingleListedList headA = new SingleListedList();
        headA.addNodeEnd(listA1);
        headA.addNodeEnd(listA2);
        headA.addNodeEnd(headAB.returnHead());
        headA.list();

        SingleListedList headB = new SingleListedList();
        headB.addNodeEnd(listB1);
        headB.addNodeEnd(listB2);
        headB.addNodeEnd(listB3);
        headB.addNodeEnd(headAB.returnHead());
        headB.list();
        //测试
        ListNode intersectionNode = getIntersectionNode_2(headA.returnHead(), headB.returnHead());
        System.out.println(intersectionNode.toString());
    }

    /**
     * 使用集合存储，遍历验算数据
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        HashSet<ListNode> setA = new HashSet<>();
        while (headA != null){
            setA.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (setA.contains(headB)){
                return headB;
            }else {
                headB = headB.next;
            }
        }
        return null;
    }

    /**
     * 双指针，浪漫相遇
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B){
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
