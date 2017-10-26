class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode reverseList(ListNode head) {
        ListNode p = null, q = head, temp = null;
        while ( q != null ) {
            temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one = new ListNode(4);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(7);
        ListNode four = new ListNode(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;
        ListNode result = solution.reverseList(one);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}