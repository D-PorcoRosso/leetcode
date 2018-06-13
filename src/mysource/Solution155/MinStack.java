package mysource.Solution155;

class MinStack {

    private int capacity = 16;
    private int[] container = new int[capacity];
    private int[] minContainer = new int[capacity]; 
    private int currentIndex = 0;
    public MinStack() {
    }
    
    public void push(int x) {
        if ( currentIndex >= capacity ) {
            capacity *= 2;
            int[] newContainer = new int[capacity];
            int[] newMinContainer = new int[capacity];
            for ( int i = 0 ; i < container.length ; i++ ) {
                newContainer[i] = container[i];
                newMinContainer[i] = minContainer[i];
            }
            container = newContainer;
            minContainer = newMinContainer;
        }
        container[currentIndex] = x;
        if ( currentIndex > 0 ) {
            if ( minContainer[currentIndex-1] > x ) {
                minContainer[currentIndex] = x;
            } else {
                minContainer[currentIndex] = minContainer[currentIndex-1];
            }
        } else {
            minContainer[currentIndex] = x;
        }
        
        currentIndex++;
    }
    
    public void pop() {
        if ( currentIndex > 0 )
            currentIndex--;
    }
    
    public int top() {
        if ( currentIndex > 0 )
            return container[currentIndex-1];
        else
            return Integer.MAX_VALUE;
    }
    
    public int getMin() {
        //System.out.println("currentIndex:"+currentIndex);
        if ( currentIndex > 0 )
            return minContainer[currentIndex-1];
        else
            return Integer.MAX_VALUE;
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