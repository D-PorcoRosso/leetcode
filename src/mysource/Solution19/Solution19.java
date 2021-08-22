package mysource.Solution19;

import java.util.HashMap;

public class Solution19 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode root = head;

        if ( head == null )
            return null;
        
        HashMap<Integer, ListNode> mapping = new HashMap<>();

        while ( head != null ) {
            count++;
            mapping.put(count, head);
            head = head.next;
        }
        int removeOne = count - n;
        if ( removeOne == 0 ) {
            return root.next;
        }
        ListNode temp = mapping.get(removeOne);
        temp.next = temp.next.next;
        
        return mapping.get(1);
    }

    public ListNode removeNthFromEnd2021(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        HashMap<Integer, ListNode> allNode = new HashMap<>();
        int count = 0;
        while (temp != null) {
            count++;
            allNode.put(count, temp);
            temp = temp.next;
        }
        if (n > count)
            return head;
        if (count == 1) {
            head = null;
        } else {
            int target = count - n +1;
            if (target == 1) {
                head = allNode.get(target).next;
            } else {
                if (allNode.get(target-1).next != null) 
                    allNode.get(target-1).next = allNode.get(target-1).next.next;
            }
        }
        return head;
    }

    public ListNode removeNthFromEnd2021_from_ans(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode start = head, end = head;

        while(end != null && n>0) {
            end = end.next;
            n--;
        }
        if(end == null) {
            head = start.next;
            return head;
        }
        while(end.next != null) {
            end = end.next;
            start = start.next;
        }
        start.next = start.next.next;
        return head;
    }

    public static void main(String[] args) {
        Solution19 solution = new Solution19();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;

        ListNode result = solution.removeNthFromEnd2021_from_ans(l1, 3);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}