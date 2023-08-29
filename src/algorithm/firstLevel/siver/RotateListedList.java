package algorithm.firstLevel.siver;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;

/**
 * 题目：旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 */
public class RotateListedList {
    public static void main(String[] args) {
        ListNode listA2 = new ListNode(1);
        ListNode listA3 = new ListNode(2);
        ListNode listA4 = new ListNode(3);
        ListNode listA5 = new ListNode(4);
        ListNode listA6 = new ListNode(5);

        SingleListedList l1 = new SingleListedList();
        l1.addNodeEnd(listA2);
        l1.addNodeEnd(listA3);
        l1.addNodeEnd(listA4);
        l1.addNodeEnd(listA5);
        l1.addNodeEnd(listA6);
        l1.list();

        ListNode listNode = rotateRight(l1.returnHead(), 2);
        System.out.println(listNode);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null  || k == 0){
            return head;
        }
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        int len = 0;
        while (temp != null){
            temp = temp.next;
            len++;
        }
        int newK = k % len;
        if (newK == 0){
            return head;
        }
        while (newK > 0){
            newK--;
            fast = fast.next;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode result = slow.next;
        slow.next = null;
        fast.next = head;
        return result;
    }
}
