package algorithm.firstLevel.siver;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;

/***
 * 题目：合并K个链表
 * 将多个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的多个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4], l3 = [2,3,4]
 * 输出：[1,1,2,2,3,3,4,4,4]
 */
public class MergeKListedList {
    public static void main(String[] args) {
        // listA 链表数据
        ListNode listA1 = new ListNode(1);
        ListNode listA2 = new ListNode(2);
        ListNode listA3 = new ListNode(4);
        // listB 链表数据
        ListNode listB1 = new ListNode(1);
        ListNode listB2 = new ListNode(3);
        ListNode listB3 = new ListNode(4);
        // listC 链表数据
        ListNode listC1 = new ListNode(2);
        ListNode listC2 = new ListNode(3);
        ListNode listC3 = new ListNode(4);

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

        SingleListedList l3 = new SingleListedList();
        l3.addNodeEnd(listC1);
        l3.addNodeEnd(listC2);
        l3.addNodeEnd(listC3);
        l3.list();

        ListNode[] lists = new ListNode[3];
        lists[0] = l1.returnHead();
        lists[1] = l2.returnHead();
        lists[2] = l3.returnHead();

        ListNode listNode = mergeKLists(lists);
        System.out.println(listNode);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (ListNode list : lists) {
            result = mergeTwoLists(result,list);
        }
        return result;
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
