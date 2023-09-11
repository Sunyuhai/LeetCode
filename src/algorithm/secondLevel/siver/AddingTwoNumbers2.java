package algorithm.secondLevel.siver;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;
import kylin.ListListed;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目：两数相加2
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 */
public class AddingTwoNumbers2 {
    public static void main(String[] args) {
        // listA 链表数据
        ListNode listA1 = new ListNode(7);
        ListNode listA2 = new ListNode(2);
        ListNode listA3 = new ListNode(4);
        ListNode listA4 = new ListNode(3);
        // listB 链表数据
        ListNode listB1 = new ListNode(5);
        ListNode listB2 = new ListNode(6);
        ListNode listB3 = new ListNode(4);

        SingleListedList l1 = new SingleListedList();
        l1.addNodeEnd(listA1);
        l1.addNodeEnd(listA2);
        l1.addNodeEnd(listA3);
        l1.addNodeEnd(listA4);
//        ListListed.list(l1.returnHead());

        SingleListedList l2 = new SingleListedList();
        l2.addNodeEnd(listB1);
        l2.addNodeEnd(listB2);
        l2.addNodeEnd(listB3);
//        ListListed.list(l2.returnHead());

        ListNode listNode = addTwoNumbers(l1.returnHead(), l2.returnHead());
        ListListed.list(listNode);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }
}
