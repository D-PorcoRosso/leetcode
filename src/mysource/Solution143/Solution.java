package mysource.Solution143;

public class Solution {
    public void reorderList(ListNode head) {
        HashMap<Integer, ListNode> mapping = new HashMap<>();
        int count = 0;
        while(head != null) {
            mapping.put(++count, head);
            head = head.next;
        }
        int index = 1;
        while(index < count - index + 1 ) {
            ListNode start = mapping.get(index);
            ListNode startNext = mapping.get(index+1);
            ListNode target = mapping.get(count - index + 1);
            ListNode preTarget = mapping.get(count - index);
            if (preTarget != start) {
                start.next = target;
                target.next = startNext;
                if (preTarget != null )
                    preTarget.next = null;
            }
            index++;
        }
    }
}
