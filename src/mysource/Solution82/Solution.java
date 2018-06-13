package mysource.Solution82;

class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode r = null;
        ListNode root = head;

        if ( head == null )
            return null;
        
        if ( head.next == null )
            return head;

        while ( head != null && head.next != null && head.val == head.next.val ) {
            while(head != null && head.next != null) {
                if ( head.val == head.next.val ) {
                    head = head.next;
                } else
                    break;
            }
            root = head.next;
            head = head.next;
        }
        
        while( head != null && head.next != null ) {
            if ( head.val == head.next.val ) {
                while(head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                if ( r != null )
                    r.next = head.next;
                /*else
                    r = head;*/
                head = head.next;
            } else {
                r = head;
                head = head.next;
            }
        }
        
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(2);
        ListNode five = new ListNode(3);
        ListNode six = new ListNode(3);
        ListNode seven = new ListNode(3);
        one.next = two; two.next = three; three.next = four; four.next = five; five.next = six; six.next = seven;
        ListNode result = solution.deleteDuplicates(one);
        while(result != null ){
            System.out.print(result.val+",");
            result = result.next;
        }
        System.out.println();
    }
}