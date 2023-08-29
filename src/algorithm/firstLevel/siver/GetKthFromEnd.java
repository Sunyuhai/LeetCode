package algorithm.firstLevel.siver;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;

/**
 * 题目：链表中倒数第K个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class GetKthFromEnd {
    public static void main(String[] args) {
        ListNode listA2 = new ListNode(1);
        ListNode listA3 = new ListNode(2);
        ListNode listA4 = new ListNode(3);
        ListNode listA5 = new ListNode(4);
        ListNode listA6 = new ListNode(5);
        ListNode listA7 = new ListNode(6);

        SingleListedList l1 = new SingleListedList();
        l1.addNodeEnd(listA2);
        l1.addNodeEnd(listA3);
        l1.addNodeEnd(listA4);
        l1.addNodeEnd(listA5);
        l1.addNodeEnd(listA6);
        l1.addNodeEnd(listA7);
        l1.list();

        ListNode kthFromEnd = getKthFromEnd(l1.returnHead(), 2);
        System.out.println(kthFromEnd);
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0){
            k--;
            fast = fast.next;
        }
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
