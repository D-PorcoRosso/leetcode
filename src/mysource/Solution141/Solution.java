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