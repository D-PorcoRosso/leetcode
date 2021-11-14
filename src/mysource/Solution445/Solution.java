package mysource.Solution445;

public class Solution {
    public ListNode addTwoNumbers_2021_google(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while(l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        return stack1.size() > stack2.size() ? sum(stack1, stack2) : sum(stack2, stack1);
    }
    private ListNode sum(Stack<ListNode> large, Stack<ListNode> small) {
        ListNode head = null;
        boolean isCarry = false;
        while(!small.isEmpty()) {
            ListNode node1 = large.pop();
            ListNode node2 = small.pop();
            head = node1;
            node1.val = node1.val+node2.val;
            if(isCarry)
                node1.val++;
            if(node1.val >= 10) {
                isCarry = true;
                node1.val = node1.val%10;
            } else
                isCarry = false;
        }
        while(!large.isEmpty()) {
            head = large.pop();
            if(isCarry)
                head.val++;
            if(head.val >= 10) {
                isCarry = true;
                head.val = head.val%10;
            } else
                isCarry = false;
        }
        if(isCarry) {
            ListNode carryHead = new ListNode(1);
            carryHead.next = head;
            return carryHead;
        }
        return head;
    }
    public ListNode addTwoNumbers_Synology(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode head = l1;
        while(head != null) {
            stack1.push(head);
            head = head.next;
        }
        head = l2;
        while(head != null) {
            stack2.push(head);
            head = head.next;
        }
        
        return stack1.size() > stack2.size() ? sum(stack1, stack2) : sum(stack2, stack1);
    }
    
    private ListNode sum(Stack<ListNode> sizeLarger, Stack<ListNode> sizeSmaller) {
        boolean carry = false;
        ListNode root = null;
        while(!sizeLarger.isEmpty() && !sizeSmaller.isEmpty()) {
            ListNode node1 = sizeLarger.pop();
            ListNode node2 = sizeSmaller.pop();
            root = node1;
            node1.val = node1.val+node2.val;
            if(carry)
                node1.val++;
            if(node1.val >= 10) {
                carry = true;
                node1.val %= 10;
            } else 
                carry = false;
        }
        
        while (!sizeLarger.isEmpty()) {
            root = sizeLarger.pop();
            if(carry)
                root.val++;
            if(root.val >= 10) {
                carry = true;
                root.val %= 10;
            } else 
                carry = false;
        }
        if (carry) {
            ListNode newRoot = new ListNode(1);
            newRoot.next = root;
            root = newRoot;
        }
        return root;
    }
}
