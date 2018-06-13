package mysource.Solution61;

class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        if ( k == 0 )
            return head;
        int count = 0;
        ListNode p = head, q = head, s;

        while ( p != null ) {
            count++;
            p = p.next;
        }
        int real_k = k % count;
        if ( real_k == 0 )
            return head;
        
        int num = count - real_k;
        p = head;
        s = p;
        while( num > 0 ) {
            if (num == 1) s = p;
            num--;
            p = p.next;
        }
        s.next = null;
        ListNode r = p;
        while ( p.next != null ) 
            p = p.next;
        p.next = q;
        return r;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode result = solution.rotateRight(one, 2);
        while(result != null){
            System.out.print(result.val+",");
            result = result.next;
        }
        System.out.println();
        ListNode one_1 = new ListNode(1);
        ListNode two_1 = new ListNode(2);
        ListNode three_1 = new ListNode(3);
        ListNode four_1 = new ListNode(4);
        ListNode five_1 = new ListNode(5);
        
        one_1.next = two_1;
        two_1.next = three_1;
        three_1.next = four_1;
        four_1.next = five_1;
        result = solution.rotateRight(one_1, 9);
        while(result != null){
            System.out.print(result.val+",");
            result = result.next;
        }
        System.out.println();
        ListNode one_2 = new ListNode(1);
        ListNode two_2 = new ListNode(2);
        ListNode three_2 = new ListNode(3);
        ListNode four_2 = new ListNode(4);
        ListNode five_2 = new ListNode(5);
        
        one_2.next = two_2;
        two_2.next = three_2;
        three_2.next = four_2;
        four_2.next = five_2;
        result = solution.rotateRight(one_2, 0);
        while(result != null){
            System.out.print(result.val+",");
            result = result.next;
        }
        System.out.println();
    }
}