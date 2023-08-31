package algorithm.secondLevel.siver;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;
import kylin.ListListed;

/**
 * 题目：两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class ReverseListTwoGroup {
    public static void main(String[] args) {
        ListNode listA2 = new ListNode(1);
        ListNode listA3 = new ListNode(2);
        ListNode listA4 = new ListNode(3);
        ListNode listA5 = new ListNode(4);

        SingleListedList l1 = new SingleListedList();
        l1.addNodeEnd(listA2);
        l1.addNodeEnd(listA3);
        l1.addNodeEnd(listA4);
        l1.addNodeEnd(listA5);
        l1.list();

        ListNode listNode = swapPairs(l1.returnHead());
        ListListed.list(listNode);

    }

    public static ListNode swapPairs(ListNode head) {
        // 1 2 3 4 5
        if (head == null || head.next == null){
            return head;
        }
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        ListNode temp = newhead;
        while (temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            //这里展示的就是 1 3 4 5，我们直接把2（node1）插入到3和4直接即可。
            node1.next = node2.next;
            node2.next = node1;
            // 这里展示的就是 1 3 2 4 5,插入成功。开始下一轮反转
            temp = node1;
        }
        return newhead.next;
    }
}
