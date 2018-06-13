package mysource.Solution237;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void deleteListNode(ListNode node, ListNode remove) {
        ListNode preNode = new ListNode(0);
        while ( node != null ) {
            if ( node != remove ) {
                preNode = node;
                node = node.next;
            } else {
                preNode.next = node.next;
                node = node.next;
            }
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
        solution.deleteNode(one);
        ListNode result = one;

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}