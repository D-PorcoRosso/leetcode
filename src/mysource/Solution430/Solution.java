package mysource.Solution430;

public class Solution {
    public Node flatten_2021_Synology(Node head) {
        Node root = dive(head);
        return head;
    }
    
    private Node dive(Node head) {
        Node iterator = head;
        while(iterator != null) {
            if (iterator.next == null && iterator.child == null)
                return iterator;
            if (iterator.child != null) {
                Node temp = iterator.next;
                iterator.next = iterator.child;
                iterator.child.prev = iterator;
                Node next = dive(iterator.child);
                iterator.child = null;
                next.next = temp;
                if (temp != null)
                    temp.prev = next;
            }
            iterator = iterator.next;
        }
        return head;
    }
}
