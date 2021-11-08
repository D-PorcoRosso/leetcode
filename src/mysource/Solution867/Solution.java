package mysource.Solution867;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode start = head;
        ListNode end = head.next;
        while(start != null && end != null) {
            start = start.next;
            if (end.next != null)
                end = end.next.next;
            else {
                end = null;
            }
        }
        return start;
    }
}
