package mysource.Solution98;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST_2021_250(TreeNode root) {
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean isValid(TreeNode root, long max, long min) {
        if (root == null)
            return true;
        
        if (root.val >= max || root.val <= min)
            return false;
        
        boolean isV = true;
        isV &= isValid(root.left, root.val, min);
        isV &= isValid(root.right, max, root.val);
        return isV;
    }

    public boolean isValidBST_2021(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, long low, long high) {
        if (root == null)
            return true;
        long currentVal = (long)root.val;
        if (currentVal <= low || currentVal >= high)
            return false;
        if (root.right != null && currentVal >= root.right.val )
            return false;
        if (root.left != null && currentVal <= root.left.val)
            return false;
        return isValid(root.right, currentVal, high) && isValid(root.left, low, currentVal);
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