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

    public boolean hasPathSum(TreeNode root, int sum) {
        if ( root == null ) {
            return false;
        }
        return has(root, sum );
    }

    private boolean has(TreeNode root, int sum) {
        
        if ( root.left == null && root.right == null ) {
            if ( root.val == sum )
                return true;
            return false;
        }
        
        if ( root.left == null && root.right != null )
            return has(root.right, sum - root.val);
        else if ( root.left != null && root.right == null )
            return has(root.left, sum - root.val);

        return has(root.left, sum - root.val) || has(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode one = new TreeNode(5);
        TreeNode two = new TreeNode(4);
        TreeNode three = new TreeNode(8);
        TreeNode four = new TreeNode(11);
        TreeNode a = new TreeNode(13);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(2);

        one.left = two;
        one.right = three;
        two.left = four;
        
        three.left = a;
        three.right = b;
        four.left = c;
        four.right = d;
        System.out.println(solution.hasPathSum(one,22));
        System.out.println(solution.hasPathSum(null,0));

        TreeNode one1 = new TreeNode(1);
        TreeNode two1 = new TreeNode(2);
        one1.left = two1;
        System.out.println(solution.hasPathSum(one1,1));
    }
}