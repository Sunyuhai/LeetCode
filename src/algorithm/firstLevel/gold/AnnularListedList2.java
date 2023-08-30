package algorithm.firstLevel.gold;

import algorithm.firstLevel.bronze.ListNode;
import algorithm.firstLevel.bronze.SingleListedList;
import com.sun.org.apache.bcel.internal.generic.FADD;

/**
 * 题目：环形链表2
 * 给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表
 * 中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class AnnularListedList2 {
    public static void main(String[] args) {
        ListNode listA2 = new ListNode(3);
        ListNode listA3 = new ListNode(2);
        ListNode listA4 = new ListNode(0);
        ListNode listA5 = new ListNode(-4);

        SingleListedList l1 = new SingleListedList();
        l1.addNodeEnd(listA2);
        l1.addNodeEnd(listA3);
        l1.addNodeEnd(listA4);
        l1.addNodeEnd(listA5);
        l1.addNodeEnd(listA3);

        ListNode listNode = detectCycle(l1.returnHead());
        System.out.println(listNode);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode index1 = slow;
                ListNode index2 = head;
                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
