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

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        preOrder(root, stack);
    }

    private void preOrder( TreeNode root, Stack<TreeNode> stack ) {
        if ( root == null )
            return;
        if ( root.left != null ) {
            if ( root.right != null ) {
                stack.push(root.right);
                root.right = root.left;
                root.left = null;
                preOrder(root.right, stack);
            } else {
                if ( !stack.isEmpty() ) {
                    TreeNode node = stack.pop();
                    root.right = node;
                }
            }
        } else {
            if (root.right != null )
                preOrder(root.right, stack);
            else{
                if ( !stack.isEmpty() ) {
                    TreeNode node = stack.pop();
                    root.right = node;
                    preOrder(root.right, stack);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(5);
        TreeNode four = new TreeNode(3);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(6);

        one.left = two;
        one.right = three;
        two.left = four;
        
        two.right = a;
        three.right = b;
        solution.flatten(one);
        TreeNode temp = one;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.right;
        }
    }
}