package algorithm.fifthLevel.challenge;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FifthLevelWork {
    public static void main(String[] args) {
        Queue<Integer> newQueue = new LinkedList<>();
        Queue<Integer> finishQueue = new LinkedList<>();
        addNewQueue(newQueue,new int[]{1,2,3,4,5});
        printQueue(newQueue,finishQueue);

        addFinishQueue(newQueue,finishQueue,3);
        printQueue(newQueue,finishQueue);

        addNewQueue(newQueue,new int[]{6,7,8,9});
        printQueue(newQueue,finishQueue);

        addFinishQueue(newQueue,finishQueue,4);
        printQueue(newQueue,finishQueue);
    }

    public static void addNewQueue(Queue<Integer> newQueue, int[] arr){
        for (int e: arr){newQueue.offer(e);}
    }

    public static void addFinishQueue(Queue<Integer> newQueue,Queue<Integer> finishQueue,int size){
        for (int i = 0; i < size; i++) {
            Integer poll = newQueue.poll();
            finishQueue.offer(poll);
        }
    }

    public static void printQueue(Queue<Integer> newQueue,Queue<Integer> finishQueue){
        Iterator<Integer> newIterator = newQueue.iterator();
        Iterator<Integer> finishIterator = finishQueue.iterator();
        System.out.println("需求队列如下：");
        while (newIterator.hasNext()){
            Integer element = newIterator.next();
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("完成队列如下：");
        while (finishIterator.hasNext()){
            Integer element = finishIterator.next();
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("-------------分割线----------------");
    }
}
