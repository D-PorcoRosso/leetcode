package mysource.Solution146;

import java.util.HashMap;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache solution = new LRUCache(3);
        solution.put(1, 1);
        solution.put(2, 2);
        solution.put(3, 3);
        solution.put(4, 4);
        System.out.println(solution.get(4));
        System.out.println(solution.get(3));
        System.out.println(solution.get(2));
        System.out.println(solution.get(1));
        solution.put(5, 5);
        System.out.println(solution.get(1));
        System.out.println(solution.get(2));
        System.out.println(solution.get(3));
        System.out.println(solution.get(4));
        System.out.println(solution.get(5));

    }

    class DoubleLinkNode {
        int key;
        int value;
        DoubleLinkNode prev;
        DoubleLinkNode next;
    }
    public void addNode(DoubleLinkNode node) {
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DoubleLinkNode node) {
        DoubleLinkNode prev = node.prev;
        DoubleLinkNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(DoubleLinkNode node) {
        removeNode(node);
        addNode(node);
    }

    public DoubleLinkNode popTail() {
        DoubleLinkNode node = tail.prev;
        removeNode(node);
        return node;
    }
    
    private HashMap<Integer, DoubleLinkNode> mapping = new HashMap<>();

    private int capacity = 0;
    private int size = 0;
    private DoubleLinkNode head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DoubleLinkNode();
        tail = new DoubleLinkNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DoubleLinkNode node = mapping.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DoubleLinkNode node = mapping.get(key);
        if (node == null) {
            if (size == capacity) {
                DoubleLinkNode tail = popTail();
                mapping.remove(tail.key);
                --size;
            }
            DoubleLinkNode newNode = new DoubleLinkNode();
            newNode.key = key;
            newNode.value = value;
            mapping.put(key, newNode);
            addNode(newNode);
            ++size;
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}
