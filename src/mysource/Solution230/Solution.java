package mysource.Solution230;

public class Solution {
    TreeNode returnNode = null;
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
