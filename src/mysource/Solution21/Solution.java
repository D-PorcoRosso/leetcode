
class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode mergeTwoLists(ListNode L1, ListNode L2) {
        if ( L1 == null && L2 == null )
            return null;
        else if ( L1 != null && L2 == null )
            return L1;
        else if ( L1 == null && L2 != null )
            return L2;
        ListNode p = new ListNode(0);
        ListNode q = new ListNode(0);
        if ( L1.val <= L2.val) {
            p = q = L1;
            L1 = L1.next;
        } else {
            p = q = L2;
            L2 = L2.next;
        }
        
        while ( L1 != null && L2 != null) {
            if ( L1.val <= L2.val ) {
                p.next = L1;
                L1 = L1.next;
                p = p.next;
            } else {
                p.next = L2;
                L2 = L2.next;
                p = p.next;
            }
        }
        if ( L1 != null)
            p.next = L1;
        else 
            p.next = L2;
        return q;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        ListNode four = new ListNode(7);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;

        ListNode one_1 = new ListNode(1);
        ListNode two_1 = new ListNode(5);
        ListNode three_1 = new ListNode(6);
        one_1.next = two_1;
        two_1.next = three_1;
        three_1.next = null;
        ListNode result = solution.mergeTwoLists(one, one_1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}