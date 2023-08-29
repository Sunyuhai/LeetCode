package algorithm.firstLevel.bronze;

public class BasicLinkedList {
    public static void main(String[] args) {
        //创建若干个链表节点
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        SingleListedList singleListedList = new SingleListedList();
        //尾部添加节点
        singleListedList.addNodeEnd(node1);
        singleListedList.addNodeEnd(node2);
        singleListedList.addNodeEnd(node5);
        singleListedList.list();

        //首部添加节点
        singleListedList.addNodeStart(node4);
        singleListedList.list();

        //获取链表长度
        int length = singleListedList.getLength();
        System.out.println(length);

        //在指定位置添加节点
        singleListedList.addNodeIndex(node3,3);
        singleListedList.list();

        //删除最后一个节点
        singleListedList.delNodeEnd();
        singleListedList.list();

        //删除首部节点
        singleListedList.delNodeStart();
        singleListedList.list();

        //在指定位置删除节点
        singleListedList.delNodeIndex(2);
        singleListedList.list();
    }
}
