package mysource.Solution142;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode twoStep = head;
        ListNode oneStep = head;
        while(head != null) {
            while (twoStep != null && oneStep != null) {
                oneStep = oneStep.next;
                if (twoStep.next == null)
                    return null;
                twoStep = twoStep.next.next;
                if (twoStep == oneStep) {
                    if (oneStep == head) {
                        return head;
                    }
                    else
                        break;
                }
            }
            head = head.next;
            oneStep = head;
            twoStep = head;
        }
        return null;
    }
}
