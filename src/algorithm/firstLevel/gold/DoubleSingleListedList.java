package algorithm.firstLevel.gold;

import algorithm.firstLevel.bronze.ListNode;

public class DoubleSingleListedList {
    //初始化链表，添加虚拟节点
    DoubleListNode headNode = new DoubleListNode(-1);

    /**
     * 遍历链表数据
     */
    public void list(){
        if (headNode.next == null){
            System.out.println("当前链表为空！");
            return;
        }
        //因为链表存在虚拟节点，所以遍历的时候要从头结点（虚拟节点）的下一个节点开始遍历
        DoubleListNode temp = headNode.next;
        while (temp.next != null){
            System.out.print(temp.toString() + " ");
            temp = temp.next;
        }
        System.out.println(temp.toString());
    }

    /**
     * 返回当前链表长度
     * @return
     */
    public int getLength(){
        int count = 0;
        if (headNode.next == null){
            return count;
        }
        DoubleListNode temp = headNode.next;
        while (temp.next != null){
            count++;
            temp = temp.next;
        }
        return count + 1;
    }

    /**
     * 在链表尾部：添加节点
     * @param node
     */
    public void addNodeEnd(DoubleListNode node){
        DoubleListNode temp = headNode;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }

    /**
     * 在链表首部：添加节点
     * @param node
     */
    public void addNodeStart(DoubleListNode node){
        node.next = headNode.next;
        headNode.next.prev = node;
        headNode.next = node;
        node.prev = headNode;
    }

    /**
     * 在链表尾部：删除节点
     */
    public void delNodeEnd(){
        DoubleListNode temp = headNode;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }


}
