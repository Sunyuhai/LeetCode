package algorithm.firstLevel.siver;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;

/***
 * 题目：合并有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class MergeListedList {
    public static void main(String[] args) {
        // listA 链表数据
        ListNode listA1 = new ListNode(1);
        ListNode listA2 = new ListNode(2);
        ListNode listA3 = new ListNode(4);
        // listB 链表数据
        ListNode listB1 = new ListNode(1);
        ListNode listB2 = new ListNode(3);
        ListNode listB3 = new ListNode(4);

        SingleListedList l1 = new SingleListedList();
        l1.addNodeEnd(listA1);
        l1.addNodeEnd(listA2);
        l1.addNodeEnd(listA3);
        l1.list();

        SingleListedList l2 = new SingleListedList();
        l2.addNodeEnd(listB1);
        l2.addNodeEnd(listB2);
        l2.addNodeEnd(listB3);
        l2.list();

        ListNode listNode = mergeTwoLists(l1.returnHead(), l2.returnHead());
        System.out.println(listNode);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newlist = new ListNode(-1);
        ListNode temp = newlist;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return newlist.next;
    }
}
