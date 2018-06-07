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

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            System.out.println(start + ", " + end);
            return null;
        }
        
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        
        return root;
    }
    
    private TreeNode buildTree(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(num[(start + end) / 2]);
        node.left = buildTree(num, start, (start + end) / 2 - 1);
        node.right = buildTree(num, (start + end) / 2 + 1, end);
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