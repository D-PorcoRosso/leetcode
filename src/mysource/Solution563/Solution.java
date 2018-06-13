package mysource.Solution563;

import java.util.Stack;
class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;
        
        return findTilt(root.left) + findTilt(root.right) + Math.abs(sumSubNode(root.left)-sumSubNode(root.right));
    }
    
    private int sumSubNode(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> nodes = new Stack();
        while ( root != null ) {
            sum += root.val;
            if ( root.right != null )
                nodes.push(root.right);
            if ( root.left != null )
                root = root.left;
            else{
                if (nodes.isEmpty())
                    root = null;
                else
                    root = nodes.pop();
            }
            //System.out.println("Press Any Key To Continue...");
            //new java.util.Scanner(System.in).nextLine();
        }
        return sum;
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
        System.out.println(solution.findTilt(one));

        System.out.println(solution.findTilt(null));

        TreeNode one_1 = new TreeNode(1);
        TreeNode two_1 = new TreeNode(2);
        TreeNode three_1 = new TreeNode(3);
        TreeNode four_1 = new TreeNode(4);
        TreeNode a_1 = new TreeNode(5);
        one_1.left = two_1;
        one_1.right = three_1;
        two_1.left = four_1;
        three_1.left = a_1;
        System.out.println(solution.findTilt(one_1));
    }
}