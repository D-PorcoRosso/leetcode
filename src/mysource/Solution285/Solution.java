package mysource.Solution285;

public class Solution {
    public TreeNode inorderSuccessor_2021_250(TreeNode root, TreeNode p) {
        return findSuccssor(root, p, new Stack<>());
    }
    
    private TreeNode findSuccssor(TreeNode root, TreeNode p, Stack<TreeNode> stack) {
        if (root.val == p.val)
            return findNext(root.right, stack);
        TreeNode node = null;
        if (root.val > p.val) {
            stack.push(root);
            node = findSuccssor(root.left, p, stack);
        } else {
            node = findSuccssor(root.right, p, stack);
        }
        return node;
    }
    
    private TreeNode findNext(TreeNode root, Stack<TreeNode> stack) {
        if (root == null)
            return stack.isEmpty() ? null : stack.pop();
        stack.push(root);
        return findNext(root.left, stack);
    }
}
