package mysource.Solution328;

public class Solution {
    public ListNode oddEvenList_2021_amz(ListNode head) {
        ListNode temp = head;
        int totalCount = 0;
        while(temp != null) {
            totalCount++;
            temp = temp.next;
        }
        int count = totalCount/2;
        temp = head;
        ListNode initNode = head;
        int t111 = (totalCount-1)/2;
        while(count > 0) {
            int innerCount = t111;
            while(temp != null && innerCount > 0) {
                ListNode p = temp.next;
                ListNode q = p == null ? null : p.next;
                if (q != null) {
                    p.next = q.next;
                    q.next = p;
                    temp.next = q;
                }
                temp = p;
                innerCount--;
            }
            ListNode gts = head;
            // while(gts != null) {
            //     System.out.print(gts.val+",");
            //     gts = gts.next;
            // }
            // System.out.println("");
            initNode = initNode.next;
            temp = initNode;
            count--;
            t111--;
        }
        return head;
    }
}
