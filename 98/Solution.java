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

    public boolean isValidBST(TreeNode root) {
        return isValidBSTWithValue(root,null, null);
    }

    private boolean isValidBSTWithValue(TreeNode root, Integer min, Integer max) {
        if ( root == null )
            return true;
        if ( root.left == null && root.right == null )
            return true;
        if ( root.left == null && root.right != null )
            if ( max == null ) {
                if ( root.right.val > root.val )
                    return isValidBSTWithValue(root.right,root.val,max);
                else
                    return false;
            } else {
                if ( root.right.val > root.val && 
                    root.right.val < max )
                    return isValidBSTWithValue(root.right,root.val,max);
                else
                    return false;
            }
        if ( root.left != null && root.right == null )
            if ( min == null) {
                if ( root.left.val < root.val )
                    return isValidBSTWithValue(root.left,min,root.val);
                else
                    return false;
            } else {
                if ( root.left.val < root.val &&
                    root.left.val > min  )
                    return isValidBSTWithValue(root.left,min,root.val);
                else
                    return false;
            }
        if ( min == null) {
            if ( root.left.val < root.val && root.right.val > root.val )
                return isValidBSTWithValue(root.left,min,root.val) && isValidBSTWithValue(root.right,root.val,max);
            else
                return false;
        } else {
            if ( root.left.val < root.val && root.right.val > root.val && root.left.val > min )
                return isValidBSTWithValue(root.left,min,root.val) && isValidBSTWithValue(root.right,root.val,max);
            else
                return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode one = new TreeNode(5);
        TreeNode two = new TreeNode(1);
        TreeNode three = new TreeNode(7);
        TreeNode four = new TreeNode(3);
        TreeNode a = new TreeNode(8);

        one.left = two;
        one.right = three;
        //two.left = four;
        //two.right = a;
        three.left = four;
        three.right = a;
        System.out.println(solution.isValidBST(one));
        System.out.println(solution.isValidBST(null));
    }
}