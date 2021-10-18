package mysource.Solution236;

public class Solution {
    TreeNode resultRoot;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        resultRoot = null;
        findNode(root, p, q);
        return resultRoot;
    }
    
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        
        boolean findLeft = findNode(root.left, p, q);
        boolean findRight = findNode(root.right, p, q);
        if (findLeft && findRight) {
            resultRoot = root;
            return true;
        }
        if (findLeft && (root.val == q.val || root.val == p.val)) {
            resultRoot = root;
            return true;
        }
        if (findRight && (root.val == q.val || root.val == p.val)) {
            resultRoot = root;
            return true;
        }
        if (root.val == q.val || root.val == p.val) {
            return true;
        }
           
        return findRight || findLeft;
    }
}
