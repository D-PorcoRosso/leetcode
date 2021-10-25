package mysource.Solution270;

public class Solution {
    double min = Double.MAX_VALUE;
    int closestV = 0;
    public int closestValue_2021_250(TreeNode root, double target) {
        if (root == null)
            return closestV;
        if (Math.abs(root.val-target) < min) {
            min = Math.abs(root.val-target);
            closestV = root.val;
        }
        if (target < root.val)
            return closestValue(root.left, target);
        else
            return closestValue(root.right, target);
    }
}
