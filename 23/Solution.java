class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int count = lists.length;
        ListNode root = null, list = null;
        while ( count > 0 ) {
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
            System.out.println(localMin.val);
            if ( localMin == null )
                break;
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
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {1,2,3,4,5};
        solution.nextPermutation(test1);
        for ( int i = 0 ; i < test1.length ; i++ )
            System.out.print(test1[i]+",");
        int[] test2 = {5,4,3,2,1};
        solution.nextPermutation(test2);
        for ( int i = 0 ; i < test2.length ; i++ )
            System.out.print(test2[i]+",");
        int[] test3 = {1,1,5};
        solution.nextPermutation(test3);
        for ( int i = 0 ; i < test3.length ; i++ )
            System.out.print(test3[i]+",");
        int[] test4 = {1,3,2};
        solution.nextPermutation(test4);
        for ( int i = 0 ; i < test4.length ; i++ )
            System.out.print(test4[i]+",");
    }
}