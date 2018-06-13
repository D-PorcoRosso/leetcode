package mysource.Solution24;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if ( head == null )
            return null;
        if ( head.next == null )
            return head;
        ListNode root = head.next;
        ListNode p = head, q = head.next, temp, r = null;
        while ( p != null && q != null ) {
            temp = q.next;
            q.next = p;
            p.next = temp;
            if ( r != null )
                r.next = q;
            r = p;
            p = temp;
            if ( p == null )
                break;
            q = p.next;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode result = solution.swapPairs(l1);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        result = solution.swapPairs(null);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        result = solution.swapPairs(new ListNode(1));
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}