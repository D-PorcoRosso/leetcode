package mysource.Solution232;

public class MyQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        if (!stack2.isEmpty()) {
            while(stack2.size() > 0) {
                stack1.push(stack2.pop());
            }
        }
        stack1.push(x);
    }
    
    public int pop() {
        if (stack1.isEmpty()) 
            return stack2.pop();
        while(stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        return stack1.pop();
    }
    
    public int peek() {
        int returnValue = 0;
        if (stack1.isEmpty()) {
            returnValue = stack2.pop();
            stack2.push(returnValue);
            return returnValue;
        }
        while(stack1.size() > 0) {
            returnValue = stack1.pop();
            stack2.push(returnValue);
        }
        return returnValue;
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
