import java.util.*;
class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if ( head == null )
            return null;
        if ( head.next == null )
            return head;
        if ( m > n ) {
            int temp = n;
            n = m;
            m = temp;
        }
        if ( (m - n) == 0 )
            return head;
        int currentNode = 1;
        ListNode preNode = null, end = head, r = head, p, q = head, root = head;
        
        while(currentNode <= m) {
            if (currentNode == (m -1))
                preNode = head;
            if (currentNode == m){
                r = head;
                end = head;
            }
            currentNode++;
            head = head.next;
        }
        p = end.next;
        System.out.println("heaad:"+head.val+" p:"+p.val+" q:"+q.val+" r:"+r.val+" end:"+end.val+" currentNode:"+currentNode);
        while ( currentNode <= n ) {
            q = p.next;
            p.next = r;
            r = p;
            p = q;
            if (currentNode == n) {
                /*if ( p == null ) {
                    preNode.next = null;
                    root = r;
                } else {
                    preNode.next = r;
                    end.next = q;
                }*/
                if ( preNode == null )
                    root = r;
                else
                    preNode.next = r;
                end.next = q;
                break;
            }
            currentNode++;
            System.out.println("p:"+p.val+" q:"+q.val+" r:"+r.val+" end:"+end.val);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two; two.next = three; three.next = four; four.next = five;
        ListNode result = solution.reverseBetween(one,2,4);
        while(result != null ){
            System.out.print(result.val+",");
            result = result.next;
        }
        System.out.println();
        ListNode one_1 = new ListNode(1);
        ListNode two_1 = new ListNode(2);
        ListNode three_1 = new ListNode(3);
        one_1.next = two_1;
        //two_1.next = three_1;
        result = solution.reverseBetween(one_1,1,2);
        while(result != null ){
            System.out.print(result.val+",");
            result = result.next;
        }
        System.out.println();
    }
}