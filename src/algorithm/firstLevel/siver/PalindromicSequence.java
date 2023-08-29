package algorithm.firstLevel.siver;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;

import java.util.Stack;

/**
 * 题目：回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 输入：head = [1,2,2,1]
 * 输出：true
 */
public class PalindromicSequence {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(2);
        ListNode list4 = new ListNode(1);

        SingleListedList singleListedList = new SingleListedList();
        singleListedList.addNodeEnd(list1);
        singleListedList.addNodeEnd(list2);
        singleListedList.addNodeEnd(list3);
        singleListedList.addNodeEnd(list4);
        singleListedList.list();

        boolean palindrome = isPalindrome_1(singleListedList.returnHead());
        System.out.println(palindrome);
    }

    /**
     * 通过将数据压栈，在遍历链表进行数据对比，判断是否回文
     * @param head
     * @return
     */
    public static boolean isPalindrome_1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        while (!stack.empty() || head != null){
            ListNode pop = stack.pop();
            if (pop.val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
