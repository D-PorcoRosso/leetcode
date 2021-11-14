package mysource.Solution141;

import java.util.ArrayList;

class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != null && fast != null) {
            if(slow == fast)
                return true;
            slow = slow.next;
            if(fast.next != null)
                fast = fast.next.next;
            else
                fast = fast.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if ( head == null )
            return false;
        ArrayList<ListNode> nodes = new ArrayList<>();
        boolean hasCycle = false;
        do {
            if ( nodes.contains(head) ) {
                hasCycle = true;
                break;
            } else {
                nodes.add(head);
            }
            head = head.next;
        } while ( head != null );

        return hasCycle;
    }

    public boolean hasCycle_2021(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode p = head, q = head.next;
        while (p != null && q != null) {
            if (p.val == q.val && p == q)
                return true;
            p = p.next;
            if (q.next == null)
                return false;
            q = q.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(7);
        ListNode four = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;
        System.out.println(solution.hasCycle(one));

        four.next = one;
        System.out.println(solution.hasCycle(one));

        four.next = two;
        System.out.println(solution.hasCycle(one));
    }
}