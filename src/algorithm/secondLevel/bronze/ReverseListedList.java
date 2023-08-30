package algorithm.secondLevel.bronze;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;

/**
 * 反转链表，在第一关的青铜挑战时，写过初始化函数中就包含反转链表。
 * 复习一遍
 */
public class ReverseListedList {
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

        ListNode listNode = reverseList(l1.returnHead());
        System.out.println(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
