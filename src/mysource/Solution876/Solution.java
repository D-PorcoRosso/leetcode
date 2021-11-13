package mysource.Solution876;

public class Solution {
    public ListNode middleNode_2021_google(ListNode head) {
        ListNode first = head;
        if(head.next == null)
            return first;
        ListNode second = head;
        do {
            first = first.next;
            second = second.next.next;
        } while( second != null && second.next != null);
        return first;
    }
}
