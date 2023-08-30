package kylin;

import algorithm.firstLevel.bronze.ListNode;

public class ListListed {
    static public void list(ListNode node){
        while (node.next != null){
            System.out.print(node + " --- ");
            node = node.next;
        }
        System.out.println(node);
    }
}
