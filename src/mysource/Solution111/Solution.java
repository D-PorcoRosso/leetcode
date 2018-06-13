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

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        return minDepth(root, 0, Integer.MAX_VALUE);
    }
    int minDepth(TreeNode node, int currDepth, int minDepth){
        if ( node == null )
            return minDepth;
        currDepth++;
        if ( node.left == null && node.right == null) {
            if ( currDepth < minDepth ) 
                minDepth = currDepth;
        }
        minDepth = minDepth(node.left, currDepth, minDepth);
        minDepth = minDepth(node.right, currDepth, minDepth);
        
        return minDepth;        
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
        System.out.println(solution.minDepth(one));

        TreeNode one1 = new TreeNode(4);
        TreeNode two1 = new TreeNode(2);
        one1.left = two1;
        System.out.println(solution.minDepth(one1));
    }
}