class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if ( headA == null || headB == null)
            return null;
        int Alength = 0, Blength = 0, largeOne = 0, shortOne = 0;
        ListNode tempA = headA, tempB = headB;
        while( tempA != null ) {
            Alength++;
            tempA = tempA.next;
        }
        while( tempB != null ) {
            Blength++;
            tempB = tempB.next;
        }
        if ( Alength >= Blength ) {
            largeOne = Alength;
            shortOne = Blength;
            tempA = headA;
            tempB = headB;
        } else {
            largeOne = Blength;
            shortOne = Alength;
            tempB = headA;
            tempA = headB;
        }

        while (largeOne != 0) {
            if ( largeOne > shortOne ) {
                largeOne = largeOne - 1;
                tempA = tempA.next;
            } else {
                if ( tempA.val == tempB.val ) {
                    return tempA;
                } else {
                    tempA = tempA.next;
                    tempB = tempB.next;
                    largeOne = largeOne - 1;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(7);
        ListNode four = new ListNode(1);
        
        ListNode one_1 = new ListNode(1);
        ListNode two_1 = new ListNode(3);
        ListNode three_1 = new ListNode(7);
        ListNode four_1 = new ListNode(1);

        one.next = null;
        two.next = three;
        three.next = four;
        four.next = null;
        one_1.next = null;
        two_1.next = null;
        /*three_1.next = four_1;
        four_1.next = null;*/
        ListNode result = solution.getIntersectionNode(one,one_1);
        if ( result != null)
            System.out.println(result.val);
    }
}