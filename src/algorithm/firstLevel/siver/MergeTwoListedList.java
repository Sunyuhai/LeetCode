package algorithm.firstLevel.siver;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;

/**
 * 题目：合并两个链表
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 */
public class MergeTwoListedList {
    public static void main(String[] args) {
        // listA 链表数据
        ListNode listA1 = new ListNode(0);
        ListNode listA2 = new ListNode(1);
        ListNode listA3 = new ListNode(2);
        ListNode listA4 = new ListNode(3);
        ListNode listA5 = new ListNode(4);
        ListNode listA6 = new ListNode(5);
        // listB 链表数据
        ListNode listB1 = new ListNode(1000000);
        ListNode listB2 = new ListNode(1000001);
        ListNode listB3 = new ListNode(1000002);

        SingleListedList l1 = new SingleListedList();
        l1.addNodeEnd(listA1);
        l1.addNodeEnd(listA2);
        l1.addNodeEnd(listA3);
        l1.addNodeEnd(listA4);
        l1.addNodeEnd(listA5);
        l1.addNodeEnd(listA6);
        l1.list();

        SingleListedList l2 = new SingleListedList();
        l2.addNodeEnd(listB1);
        l2.addNodeEnd(listB2);
        l2.addNodeEnd(listB3);
        l2.list();

        ListNode listNode = mergeInBetween(l1.returnHead(), 3, 4, l2.returnHead());
        System.out.println(listNode);
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list1;
        ListNode temp3 = list2;
        while (temp3.next != null){
            temp3 = temp3.next;
        }
        while (b > 0){
            b--;
            temp2 = temp2.next;
        }
        temp3.next = temp2.next;
        a--;
        while (a > 0){
            a--;
            temp1 = temp1.next;
        }
        temp1.next = list2;
        return list1;
    }
}
