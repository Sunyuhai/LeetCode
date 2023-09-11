package algorithm.secondLevel.siver;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;
import kylin.ListListed;

/**
 * 题目：给单链表加一
 * 给定一个用链表表示的非负整数， 然后将这个整数 再加上 1 。
 * 这些数字的存储是这样的：最高位有效的数字位于链表的首位 head 。
 * 示例：
 * 输入: head = [1,2,3]
 * 输出: [1,2,4]
 */
public class PlusOne {
    public static void main(String[] args) {
        ListNode listA2 = new ListNode(1);
        ListNode listA3 = new ListNode(2);
        ListNode listA4 = new ListNode(3);

        SingleListedList l1 = new SingleListedList();
        l1.addNodeEnd(listA2);
        l1.addNodeEnd(listA3);
        l1.addNodeEnd(listA4);
        ListListed.list(l1.returnHead());

        ListNode listNode = plusOne(l1.returnHead());
        ListListed.list(listNode);
    }

    public static ListNode plusOne(ListNode head) {
        ListNode reverList = reverListed(head);
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode temp = res;
        int count = 1;
        while (reverList != null){
            int sum = carry + reverList.val + count;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode curList = new ListNode(sum);
            curList.next = temp.next;
            temp.next = curList;
            reverList = reverList.next;
            count = 0;
        }
        return res.next;
    }

    public static ListNode reverListed(ListNode node){
        ListNode cur = node;
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
