package mysource.Solution155;

import java.util.Stack;

class MinStack {
    
    private Stack<Integer> container = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    private int currentMin = 0;
    
    public MinStack() {
    }
    
    public void push(int x) {
        if (container.isEmpty())
            currentMin = x;
        else
            currentMin = Math.min(x, min.peek());
        container.push(x);
        min.push(currentMin);
    }
    
    public void pop() {
        min.pop();
        container.pop();
    }
    
    public int top() {
        return container.peek();
    }
    
    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-4);
        System.out.println(minStack.getMin());//   --> Returns -3.
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());//      --> Returns 0.
        System.out.println(minStack.getMin());// --> Returns -2.
    }
}