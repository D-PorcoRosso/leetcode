package mysource.Solution110;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced_2021_250(TreeNode root) {
        return isBalancedBST(root);
    }
    
    private boolean isBalancedBST(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1) {
            boolean isBalanced = true;
            isBalanced &= isBalancedBST(root.left);
            isBalanced &= isBalancedBST(root.right);
            return isBalanced;
        }
        return false;
    }
    
    private int treeHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

    private int traverseDepth(TreeNode root) throws Exception {
        if ( root == null )
            return 0;
        int left = traverseDepth(root.left);
        int right = traverseDepth(root.right);
        if ( Math.abs(left - right) > 1) {
            throw new Exception("not balanced");
        } else {
            return left > right ? left + 1 : right + 1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        try {
            traverseDepth(root);
        } catch ( Exception e ) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode one = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(7);
        TreeNode four = new TreeNode(1);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(9);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = a;
        three.left = b;
        three.right = c;

        System.out.println(solution.isBalanced(one));

        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(9);
        four.left = d;
        d.left = e;

        System.out.println(solution.isBalanced(one));
    }
}