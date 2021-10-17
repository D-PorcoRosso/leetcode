package mysource.Solution230;

public class Solution {
    TreeNode returnNode = null;

    private int count = 0;
    private int result = 0;
    public int kthSmallest_2021_250(TreeNode root, int k) {
        tracePath(root, k);
        return result;
    }
    
    public void tracePath(TreeNode root, int k) {
        if (root == null)
            return;
        tracePath(root.left, k);
        count++;
        if (k == count)
            result = root.val;
        tracePath(root.right, k);
    }

    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        infix(root);
        if (returnNode != null) {
            return returnNode.val;
        }
        return -1;
    }
    
    private void infix(TreeNode node) {
        if (node == null)
            return;
        infix(node.left);
        System.out.println("current node:"+node.val+" count:"+count);
        --count;
        if ( count == 0 ) {
            returnNode = node;
        }
        infix(node.right);
    }
}
