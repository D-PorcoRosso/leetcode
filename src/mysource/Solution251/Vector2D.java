package mysource.Solution251;

public class Vector2D {

    Queue<Integer> container = new LinkedList<>();
    
    public Vector2D(int[][] vec) {
        for ( int[] v : vec ) {
            for ( int num : v ) {
                container.offer(num);
            }
        }
    }
    
    public int next() {
        Integer next = null;
        if (!container.isEmpty()) {
            return container.poll();
        }
        return next;
    }
    
    public boolean hasNext() {
        return !container.isEmpty();
    }
}
