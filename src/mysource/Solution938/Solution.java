package mysource.Solution938;

public class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        int needToSum = 0;
        if (root.val <= high && root.val >= low) {
            needToSum = root.val;
        }
        return needToSum + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
    public int rangeSumBST_remove_branch(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        int needToSum = 0;
        if (root.val <= high && root.val >= low) {
            needToSum = root.val;
            return needToSum + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val > high)
            return needToSum + rangeSumBST(root.left, low, high);
        else
            return needToSum + rangeSumBST(root.right, low, high);
    }
}
