package algorithm.firstLevel.bronze;

public class SingleListedList {
    //初始化链表，添加虚拟节点 -1
    ListNode headNode = new ListNode(-1);

    /**
     * 遍历链表数据
     */
    public void list(){
        if (headNode.next == null){
            System.out.println("当前链表为空！");
            return;
        }
        //因为链表存在虚拟节点，所以遍历的时候要从头结点（虚拟节点）的下一个节点开始遍历
        ListNode temp = headNode.next;
        while (temp.next != null){
            System.out.print(temp.toString() + " ");
            temp = temp.next;
        }
        System.out.println(temp.toString());
    }

    public int getLength(){
        int count = 0;
        if (headNode.next == null){
            return count;
        }
        ListNode temp = headNode.next;
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
    public void addNodeEnd(ListNode node){
        ListNode temp = headNode;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 在链表首部：添加节点
     * @param node
     */
    public void addNodeStart(ListNode node){
        node.next = headNode.next;
        headNode.next = node;
    }

    /**
     * 按照指定位置：添加节点
     * @param node
     * @param index
     */
    public void addNodeIndex(ListNode node,int index){
        int length = getLength();
        if(index >= length || index <= 1){
            System.out.println("当前索引值不规范，请设置中间值插入！");
            return;
        }


    }
}
