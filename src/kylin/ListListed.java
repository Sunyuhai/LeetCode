package kylin;

import algorithm.firstLevel.bronze.ListNode;

public class ListListed {
    static public void list(ListNode node){
        if (node == null){
            System.out.println("当前链表为空！");
            return;
        }
        while (node.next != null){
            System.out.print(node + " --- ");
            node = node.next;
        }
        System.out.println(node);
    }
}
