package mysource.Solution2;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rootL1 = l1, tempSave;
        boolean needCarry = false;

        while ( l1 != null || l2 != null ) {
            //System.out.println(l1.val+":"+l2.val);        
            //new java.util.Scanner(System.in).nextLine();
            if ( l1 != null && l2 != null ) {
                l1.val = l1.val+l2.val;
                if ( needCarry ) 
                    l1.val++;
                if ( l1.val > 9 ) {
                    needCarry = true;
                    l1.val -= 10;
                } else {
                    needCarry = false;
                }

                if ( l1.next == null && l2.next == null ) {
                    if ( needCarry ) {
                        l1.next = new ListNode(1);
                        needCarry = false;
                    }
                    break;
                } else if ( l1.next != null && l2.next != null) {
                    l1 = l1.next;
                    l2 = l2.next;
                } else {
                    if ( l1.next == null ){
                        l1.next = l2.next;
                    }
                    l1 = l1.next;
                    break;
                }
            }
        }

        while (l1 != null) {
            System.out.println("va;:"+l1.val);
            if (needCarry) 
                l1.val++;
            if (l1.val > 9) {
                needCarry = true;
                l1.val -= 10;
            } else
                needCarry = false;
            if (l1.next == null) {
                if ( needCarry ) {
                    l1.next = new ListNode(1);
                }
                break;
            } else
                l1 = l1.next;
        }
        
        return rootL1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;

        ListNode r1 = new ListNode(1);
        //ListNode r2 = new ListNode(6);
        //ListNode r3 = new ListNode(4);
        //r1.next = r2;
        //r2.next = r3;

        ListNode result = solution.addTwoNumbers(r1, l1);
        System.out.println(result);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}