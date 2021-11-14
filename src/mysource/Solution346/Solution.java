package mysource.Solution346;

class MovingAverage {

    int queueSize = 0;
    Queue<Integer> queue = new LinkedList<>();
    public MovingAverage(int size) {
        this.queueSize = size;
    }
    
    public double next(int val) {
        if(queue.size() == this.queueSize) {
            queue.poll();
        }
        queue.offer(val);
        double sum = 0;
        for(int n : queue) {
            sum += n;
        }
        return sum/queue.size();
    }
}