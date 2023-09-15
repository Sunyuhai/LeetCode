package algorithm.secondLevel.gold;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;
import kylin.ListListed;

/**
 * 题目：K个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 */
public class ReverseListKGroup {
    public static void main(String[] args) {
        ListNode listA0 = new ListNode(1);
        ListNode listA1 = new ListNode(2);
        ListNode listA2 = new ListNode(3);
        ListNode listA3 = new ListNode(4);
        ListNode listA4 = new ListNode(5);

        SingleListedList l1 = new SingleListedList();
        l1.addNodeEnd(listA0);
        l1.addNodeEnd(listA1);
        l1.addNodeEnd(listA2);
        l1.addNodeEnd(listA3);
        l1.addNodeEnd(listA4);
        ListListed.list(l1.returnHead());

        ListNode listNode = reverseKGroup2(l1.returnHead(), 2);
        ListListed.list(listNode);

    }
    /**
     * 头插法+递归
     */
    public static ListNode reverseKGroup1(ListNode head, int k) {
        // 定义虚拟节点
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        // 定义当前节点
        ListNode cur = head;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        // 判断一共有几组需要翻转
        int group = len / k;
        System.out.println(group);
        // 保留虚拟节点，移动节点则交给pre
        ListNode pre = newhead;
        // 初始化当前节点，就是头节点
        cur = head;
        for (int i = 0; i < group; i++) {
            for (int j = 0; j < k - 1; j++) {
                // 开始按照每组翻转，按照头插法实现
                ListNode temp = cur.next;
                cur.next = cur.next.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return newhead.next;
    }


    /**
     * 📠引线法
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {
        //暂时搁置
        return null;
    }
}
