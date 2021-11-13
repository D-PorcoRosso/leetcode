package mysource.Solution206;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode reverseList_2021_google(ListNode head) {
        if (head == null)
            return null;
        ListNode p = head, q = p.next, r = null;
        while( p != null) {
            p.next = r;
            r = p;
            p = q;
            if (q != null)
                q = q.next;
        }
        return r;
    }

    public ListNode reverseList_2021(ListNode head) {
        ListNode p = head,q = head,r = null;
        while(p != null) {
            p = p.next;
            q.next = r;
            r = q;
            q = p;
        }
        return r;
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

    public ListNode reverseList2(ListNode head) {
        return reverse2(head, null);
    }

    private ListNode reverse2(ListNode head, ListNode p) {
        if ( head != null ) {
            ListNode temp = head.next;
            //System.out.println(head.val);
            head.next = p;
            return reverse2(temp, head);
        } else {
            return p;
        }
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
        ListNode result = solution.reverseList2(one);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}