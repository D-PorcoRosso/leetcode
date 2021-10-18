package mysource.Solution232;

public class MyQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        while(stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        int returnValue = stack1.pop();
        while(stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        return returnValue;
    }
    
    public int peek() {
        int returnValue = 0;
        while(stack1.size() > 0) {
            returnValue = stack1.pop();
            stack2.push(returnValue);
        }
        while(stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        return returnValue;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}
