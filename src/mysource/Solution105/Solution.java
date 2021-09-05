package mysource.Solution105;

public class Solution {
    private int nodeCount = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1);
    }
    private TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if ( left > right )
            return null;
        int currentValue = preorder[nodeCount++];
        TreeNode root = new TreeNode(currentValue);
        root.left = build(preorder, inorder, left, getIndex(currentValue, inorder) - 1);
        root.right = build(preorder, inorder, getIndex(currentValue, inorder)+1, right);
        return root;
    }
    private int getIndex(int target, int[] inorder) {
        for (int i = 0 ; i < inorder.length ; i++) {
            if (target == inorder[i])
                return i;
        }
        return -1;
    }
}
