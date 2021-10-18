package mysource.Solution235;

public class Solution {
    public TreeNode lowestCommonAncestor_2021_250(TreeNode root, TreeNode p, TreeNode q) {
        return findAncestor(root, p, q);
    }
    
    private TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((q.val <= root.val && root.val <= p.val) || (p.val <= root.val && root.val <= q.val))
            return root;
        
        if (root.val > p.val && root.val > q.val) {
            return findAncestor(root.left, p, q);
        }
        return findAncestor(root.right, p, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val))
            return root;
        if (root.val <= p.val && root.val <= q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val >= p.val && root.val >= q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return null;
    }
}
