import java.util.*;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if ( nums.length == 0 ) {
            return null;
        }
        int start = 0, end = nums.length - 1;
        return generateTree(nums, start, end);
    }

    private TreeNode generateTree(int[] nums, int start, int end) {
        if (start >= end) {
            if ( start == end && end == nums.length - 1 ) {
                return new TreeNode(nums[end]);
            }
            return null;
        }
        
        int middle = ( start + end )/2;
        TreeNode root = new TreeNode(nums[middle]);
        System.out.println(root.val+":"+start+":"+middle+":"+end);
        root.left = generateTree(nums, start, middle);
        root.right = generateTree(nums, middle + 1, end);
        return root;
    }
    
    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {-10,-3,0,5,9};
        TreeNode root = solution.sortedArrayToBST(test1);
        print(root);
    }

    private static void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while( !queue.isEmpty() ) {
            TreeNode node = queue.poll();
            if ( node != null ) {
                System.out.println(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }
}