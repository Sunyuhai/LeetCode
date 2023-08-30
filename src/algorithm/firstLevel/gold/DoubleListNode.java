package algorithm.firstLevel.gold;

public class DoubleListNode {
    public int data;
    public DoubleListNode prev;
    public DoubleListNode next;

    public DoubleListNode(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "DoubleListNode{" +
                "data=" + data +
                '}';
    }
}
