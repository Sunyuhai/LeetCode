package algorithm.firstLevel.gold;


public class DoubleBasicLinkedList {
    public static void main(String[] args) {
        //创建若干个链表节点
        DoubleListNode node1 = new DoubleListNode(1);
        DoubleListNode node2 = new DoubleListNode(2);
        DoubleListNode node3 = new DoubleListNode(3);
        DoubleListNode node4 = new DoubleListNode(4);
        DoubleListNode node5 = new DoubleListNode(5);

        DoubleSingleListedList doubleSingleListedList = new DoubleSingleListedList();
        doubleSingleListedList.addNodeEnd(node1);
        doubleSingleListedList.addNodeEnd(node2);
        doubleSingleListedList.addNodeEnd(node3);
        doubleSingleListedList.list();

        doubleSingleListedList.addNodeStart(node4);
        doubleSingleListedList.list();

    }
}
