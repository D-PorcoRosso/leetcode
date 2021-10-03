package mysource.Solution116;

public class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        process(root, new LinkedList<>());
        return root;
    }
    
    private void process(Node root, Queue<Node> queue) {
        queue.add(root);
        
        while(queue.size() != 0) {
            int size = queue.size();
            for ( int i = 0 ; i < size ; i++ ) {
                Node n = queue.poll();
                if (i == size-1)
                    n.next = null;
                else {
                    Node node = queue.peek();
                    n.next = node;
                }

                if (n.left != null) {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
            }
        }
    }
}
