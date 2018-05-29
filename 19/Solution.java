public class Solution {
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

        while ( head != null ) {
            count++;
            head = head.next;
        }
        int removeOne = count - n;
        if ( removeOne == 0 ) {
            return root.next;
        }
        count = 0;
        head = root;
        while(true) {
            if ( count == removeOne - 1 ) {
                ListNode temp = head.next;
                head.next = head.next.next;
                temp = null;
                break;
            }
            System.out.println(head.val);
            head = head.next;
            count++;
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

        ListNode result = solution.removeNthFromEnd(l1, 1);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}