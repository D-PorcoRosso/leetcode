package mysource.Solution101;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric_2021_250(TreeNode root) {
        if (root != null && root.left != null && root.right != null) {
            if (root.left.val == root.right.val)
                return isSym(root.left, root.right);
        }
        if (root != null && root.left == null && root.right == null)
            return true;
        return false;        
    }
    
    private boolean isSym (TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            if (left.val == right.val) {
                boolean isS = true;
                isS &= isSym(left.right, right.left);
                isS &= isSym(left.left, right.right);
                return isS;
            }
        } else if (left == null && right == null)
            return true;
        
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if ( root == null )
            return true;
        
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if ( left == null && right == null ) {
            return true;
        } else if ( left == null || right == null ) {
            return false;
        } else if ( left.val == right.val ) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(2);
        //TreeNode four = new TreeNode(3);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(3);
        //TreeNode c = new TreeNode(3);

        one.left = two;
        one.right = three;
        //two.left = four;
        two.right = a;
        three.left = b;
        //three.right = c;

        System.out.println(solution.isSymmetric(one));
    }
}