package mysource.Solution298;

public class Solution {
    int longest = 0;
    public int longestConsecutive_2021_250(TreeNode root) {
        findPath(root, root == null ? 0 : 1, 1000000);
        return longest;
    }
    
    private void findPath(TreeNode root, int currentCount, int previusValue) {
        if (root == null)
            return;
        if (root.val == previusValue+1) {
            longest = Math.max(longest, currentCount+1);
            findPath(root.left, currentCount+1, root.val);
            findPath(root.right, currentCount+1, root.val);
        } else {
            longest = Math.max(longest, 1);
            findPath(root.left, 1, root.val);
            findPath(root.right, 1, root.val);
        }
    }
}
