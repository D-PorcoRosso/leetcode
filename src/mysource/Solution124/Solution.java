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
}
