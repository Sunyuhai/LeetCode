package kylin;

public class Main {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // 反转链表的方法
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev; // 返回反转后的头节点
    }

    // 合并两个链表的方法
    public static Node mergeLists(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node current = dummy;

        while (list1 != null || list2 != null) {
            if (list1 != null) {
                current.next = list1;
                list1 = list1.next;
                current = current.next;
            }
            if (list2 != null) {
                current.next = list2;
                list2 = list2.next;
                current = current.next;
            }
        }

        return dummy.next;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 创建链表并初始化
        Node head = new Node(1);
        Node current = head;
        for (int i = 2; i <= 10; i++) {
            current.next = new Node(i);
            current = current.next;
        }

        // 分成两个链表，奇数位置和偶数位置
        Node odd = head;
        Node even = head.next;

        // 反转偶数链表
        even = reverseList(even);

        // 合并两个链表
        Node result = mergeLists(odd, even);

        // 打印结果链表
        printList(result);
    }
}
