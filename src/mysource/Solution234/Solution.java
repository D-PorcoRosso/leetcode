package mysource.Solution234;

class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        int index = 0, half = length/2;
        double sum = 0;
        while( index < length ) {
            if ( index < half ) {
                if (length % 2 == 0 ){
                    sum += head.val * Math.pow(10,(half - index -1));
                } else 
                    sum += head.val * Math.pow(10,(half - index));
            } else if ( index > half ) {
                sum -= head.val * Math.pow(10,(index - half));
            } else {
                if (length % 2 == 0 ){
                    sum -= head.val;
                }
            }
            System.out.println(sum);
            index++;
            head = head.next;
        }
        if ( sum == 0 ) 
            return true;
        return false;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(-16557);
        ListNode n2 = new ListNode(-8725);
        ListNode n3 = new ListNode(-29125);
        ListNode n4 = new ListNode(28873);
        ListNode n5 = new ListNode(-21702);
        ListNode n6 = new ListNode(15483);
        ListNode n7 = new ListNode(-28441);
        ListNode n8 = new ListNode(-17845);
        ListNode n9 = new ListNode(-4317);
        ListNode n10 = new ListNode(-10914);
        ListNode n11 = new ListNode(-10914);
        ListNode n12 = new ListNode(-4317);
        ListNode n13 = new ListNode(-17845);
        ListNode n14 = new ListNode(-28441);
        ListNode n15 = new ListNode(15483);
        ListNode n16 = new ListNode(-21702);
        ListNode n17 = new ListNode(28873);
        ListNode n18 = new ListNode(-29125);
        ListNode n19 = new ListNode(-8725);
        ListNode n20 = new ListNode(-16557);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;
        n15.next = n16;
        n16.next = n17;
        n17.next = n18;
        n18.next = n19;
        n19.next = n20;
        n20.next = null;
    

        Solution solution = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(7);
        ListNode four = new ListNode(1);

        ListNode one_1 = new ListNode(1);
        ListNode two_1 = new ListNode(2);
        ListNode three_1 = new ListNode(3);
        ListNode four_1 = new ListNode(3);
        ListNode five_1 = new ListNode(2);
        ListNode six_1 = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;
        one_1.next = two_1;
        two_1.next = three_1;
        three_1.next = four_1;
        four_1.next = five_1;
        five_1.next = six_1;
        six_1.next = null;
        System.out.println(solution.isPalindrome(n1));
        System.out.println(solution.isPalindrome(one_1));
    }
}