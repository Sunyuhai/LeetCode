package algorithm.fourthLevel.bronze;

import java.util.Stack;

public class PrintStack<T> {
    public void printStack(Stack<T> stack){
        for(T em : stack){
            System.out.print(em + " ");
        }
        System.out.println();
    }
}
