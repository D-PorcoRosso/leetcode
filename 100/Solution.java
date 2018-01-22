import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null )
            return true;
        else {
            if ( p != null && q == null )
                return false;
            if ( q != null && p == null )
                return false;
            if ( p.val != q.val )
                return false;
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            if (left && right)
                return true;
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