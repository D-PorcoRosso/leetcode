package mysource.Solution295;

class MedianFinder {

    List<Integer> container = null;

    /** initialize your data structure here. */
    public MedianFinder() {
        container = new ArrayList<>();
    }
    
    public void addNum(int num) {
        container.add(num);
        Collections.sort(container);
    }
    
    public double findMedian() {
        int size = container.size();
        double median = 0.0;
        if (size % 2 == 0) {
            median = (container.get(size/2) + container.get(size/2-1))/2.0;
        } else {
            median = container.get(size/2);
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */