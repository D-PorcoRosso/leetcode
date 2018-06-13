import java.util.*;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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