package algorithm.fifthLevel.gold;

import java.util.HashMap;

/**
 * 题目：LRU缓存
 * 请你设计并实现一个满足
 * LRU (最近最少使用) 缓存 约束的数据结构。
 *  LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 *  int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *  void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-
 * value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 */
public class LRUCache {
    class ListNode{
        int key;
        int value;
        ListNode next;
        ListNode pre;
        ListNode(){}
        ListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer,ListNode> resultHashMap = new HashMap<>();
    int capacity;
    int size;
    // 定义虚拟头结点
    ListNode head;
    // 定义虚拟尾结点
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        ListNode curNode = resultHashMap.get(key);
        if (curNode == null){
            return -1;
        }
        moveToHead(curNode);
        return curNode.value;
    }

    private void moveToHead(ListNode curNode) {
        deleteNode(curNode);
        addToHead(curNode);
    }

    private void addToHead(ListNode curNode) {
        curNode.next = head.next;
        curNode.pre = head;
        head.next.pre = curNode;
        head.next = curNode;
    }

    private void deleteNode(ListNode curNode) {
        curNode.pre.next = curNode.next;
        curNode.next.pre = curNode.pre;
    }

    private ListNode deleteTail(){
        ListNode tailNode = tail.pre;
        deleteNode(tailNode);
        return tailNode;
    }

    public void put(int key, int value) {
        ListNode curNode = resultHashMap.get(key);
        if (curNode == null){
            ListNode node = new ListNode(key,value);
            resultHashMap.put(key,node);
            addToHead(node);
            size++;
            if (size > capacity){
                ListNode tailNode = deleteTail();
                resultHashMap.remove(tailNode.key);
                size--;
            }
        }else {
            curNode.value = value;
            moveToHead(curNode);
        }
    }
}
