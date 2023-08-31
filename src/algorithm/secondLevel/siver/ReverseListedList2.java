package algorithm.secondLevel.siver;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;

/**
 * 题目：反转链表2
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节
 * 点，返回 反转后的链表 。
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 */
public class ReverseListedList2 {
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

        ListNode listNode = reverseBetween(l1.returnHead(),2,4);
        System.out.println(listNode);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        //输入：head = [-1,1,2,3,4,5], left = 2, right = 4
        //输出：[1,4,3,2,5]
        ListNode leftNode = newhead;
        ListNode rigthNode = newhead;
        for (int i = 0; i < left - 1; i++) {
            leftNode = leftNode.next;
        }
        ListNode reverseNode = leftNode.next;
        for (int i = 0; i < right; i++) {
            rigthNode = rigthNode.next;
        }
        ListNode foot = rigthNode.next;

        rigthNode.next = null;
        leftNode.next = null;
        reverseList(reverseNode);

        leftNode.next = rigthNode;
        reverseNode.next = foot;

        return newhead.next;
    }

    public static void reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
    }
}
