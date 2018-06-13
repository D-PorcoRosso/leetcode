package mysource.Solution23;

class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int count = lists.length;
        ListNode root = null, list = null;
        if ( count == 1 )
            return lists[0];
        while ( count > 1 ) {
            count = 0;
            ListNode localMin = null;
            int localMinIndex = 0;
            for ( int i = 0 ; i < lists.length ; i++ ) {
                ListNode node = lists[i];
                if ( node != null ) {
                    localMin = node;
                    localMinIndex = i;
                    break;
                }
            }
            if ( localMin == null )
                break;
            System.out.println(localMin.val+"\n");
            for ( int i = 0 ; i < lists.length ; i++ ) {
                ListNode node = lists[i];
                if ( node != null ) {
                    System.out.print(node.val+",");
                    if ( localMin.val > node.val ) {
                        localMin = node;
                        localMinIndex = i;
                    }
                    count++;
                }
            }
            lists[localMinIndex] = localMin.next;
            if( root == null ) {
                root = localMin;
                list = root;
            } else {
                list.next = localMin;
                list = list.next;
            }
            for ( int i = 0 ; i < lists.length ; i++ ) {
                if ( lists[i] != null ) {
                    if ( localMin.val == lists[i].val ) {
                        list.next = lists[i];
                        list = list.next;
                        lists[i] = lists[i].next;
                    }
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}