package mysource.Solution124;

public class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        findMax(root);
        return max;
    }
    
    private int findMax(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));
        max = Math.max(max, left+right+root.val);
        return Math.max(left,right)+root.val;
    }

    private int max = Integer.MIN_VALUE;
    public int maxPathSum_2021_250(TreeNode root) {
        findMax(root);
        return max;
    }
    
    private int findMax(TreeNode root) {
        if (root == null)
            return 0;
        
        int rightMax = findMax(root.right);
        int leftMax = findMax(root.left);
        int localMax = Math.max(root.val, Math.max( root.val+leftMax, Math.max(root.val+rightMax, (root.val + rightMax + leftMax))));
        if (localMax > max)
            max = localMax;
        return Math.max(root.val, root.val + Math.max(rightMax, leftMax));
    }
}
