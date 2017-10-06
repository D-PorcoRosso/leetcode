class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode index = head;
    
        while (index.next != null) {
            if (index.val == index.next.val) {
                index.next = index.next.next;
            } else {
                index = index.next;
            }
            /*try{
                System.in.read();
            }catch(Exception e){};*/
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(3);
        ListNode five = new ListNode(3);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        ListNode result = solution.deleteDuplicates(one);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}