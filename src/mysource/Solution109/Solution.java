package mysource.Solution109;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> array = new ArrayList<>();
        while(head != null) {
            array.add(head.val);
            head = head.next;
        }
        int[] nums = new int[array.size()];
        for ( int i = 0 ; i < array.size() ; i++ ) {
            nums[i] = array.get(i);
        }
        
        return buildTree(nums, 0, nums.length-1);
    }
    
    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end){
            return null;
        }
        int mid = (end-start)/2 + start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid-1);
        root.right = buildTree(nums, mid+1, end);
        return root;
    }
}
