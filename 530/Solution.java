import java.util.Stack;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE, preNum = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();

        while ( true ) {
            //System.out.println("root:"+root.val);
            //new java.util.Scanner(System.in).nextLine();
            if ( root.left != null ) {
                //System.out.println("root.left != null");
                stack.push(root);
                root = root.left;
            } else if ( root.right != null ) {
                //System.out.println("root.right != null");
                int diff = Math.abs(root.val - preNum);
                if ( diff < min ) {
                    min = diff;
                }
                preNum = root.val;
                TreeNode temp = root.right;
                root.right = null;
                root = temp;
            } else {
                //System.out.println("both = null");
                int diff = Math.abs(root.val - preNum);
                if ( diff < min ) {
                    min = diff;
                }
                preNum = root.val;
                if ( stack.isEmpty() )
                    break;
                else {
                    root = stack.pop();
                    root.left = null;
                }
            }
        }
        return min;
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
        System.out.println(solution.getMinimumDifference(one));

        TreeNode one_1 = new TreeNode(1);
        TreeNode two_1 = new TreeNode(2);
        TreeNode three_1 = new TreeNode(3);
        one_1.right = three_1;
        three_1.left = two_1;
        System.out.println(solution.getMinimumDifference(one_1));
    }
}