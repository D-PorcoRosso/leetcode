package mysource.Solution708;

public class Solution {
    public Node insert_2021_google(Node head, int insertVal) {
        if(head == null) {
            Node root = new Node(insertVal);
            root.next = root;
            return root;
        }
        Node node = head, preNode = head.next;
        if(node == preNode) {
            Node n = new Node(insertVal);
            node.next = n;
            n.next = node;
            return head;
        }
        Node smallest = node, largest = node;
        
        while(true) {
            preNode = node;
            node = node.next;
            smallest = node.val < smallest.val ? node : smallest;
            largest = node.val >= largest.val ? node : largest;
            if((insertVal <= node.val && preNode.val <= insertVal)) {
                Node insert = new Node(insertVal);
                preNode.next = insert;
                insert.next = node;
                break;
            }
            if (node == head) {
                Node insert = new Node(insertVal);
                if (smallest != largest) {
                    largest.next = insert;
                    insert.next = smallest;
                } else {
                    preNode.next = insert;
                    insert.next = node;
                }
                break;
            }
        }
        return head;
    }
}
