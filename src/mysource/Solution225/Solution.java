package mysource.Solution225;

public class Solution {
    
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    
    public MyStack() {
        
    }
    
    public void push(int x) {
        if (queue1.size() == 0) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
    }
    
    public int pop() {
        if (queue1.size() == 0) {
            dump(queue2, queue1);
            int topValue = queue2.poll();
            return topValue;
        } else {
            dump(queue1, queue2);
            int topValue = queue1.poll();
            return topValue;
        }
    }
    
    public int top() {
        if (queue1.size() == 0) {
            dump(queue2, queue1);
            int topValue = queue2.poll();
            queue1.offer(topValue);
            return topValue;
        } else {
            dump(queue1, queue2);
            int topValue = queue1.poll();
            queue2.offer(topValue);
            return topValue;
        }
    }
    
    private void dump(Queue<Integer> from, Queue<Integer> to) {
        while(from.size() > 1) {
            to.offer(from.poll());
        }
    }
    
    public boolean empty() {
        if (queue1.size() == 0 && queue2.size() == 0)
            return true;
        return false;
    }
}
