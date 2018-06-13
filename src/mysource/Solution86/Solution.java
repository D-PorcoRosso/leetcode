package mysource.Solution86;

class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode target = head;
        while(target != null) {
            if ( target.val == x )
                break;
            target = target.next;
        }

        ListNode find = target;
        ListNode compareNode = null, otherRoot = null;

        while( find != null ) {
            if ( target.val > find.val ) {
                if ( otherRoot == null ) {
                    otherRoot = find;
                    compareNode = otherRoot;
                } else {
                    otherRoot.next = find;
                    otherRoot = otherRoot.next;
                }
                find = find.next;
            }
        }
        System.out.println();
        return compareNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(2);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(2);
        one.next = two; two.next = three; three.next = four; four.next = five; five.next = six;
        ListNode result = solution.partition(one, 4);
        while(result != null ){
            System.out.print(result.val+",");
            result = result.next;
        }
        System.out.println();
    }
}