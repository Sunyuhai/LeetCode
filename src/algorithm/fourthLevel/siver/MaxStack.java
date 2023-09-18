package algorithm.fourthLevel.siver;

import java.util.Stack;

/**
 * 题目：最大栈
 */
public class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack();
        maxStack = new Stack();
        maxStack.push(Integer.MIN_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        maxStack.push(Math.max(x,maxStack.peek()));

    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}
