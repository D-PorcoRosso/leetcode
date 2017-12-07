import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.EmptyStackException;


class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while ( root != null ) {
            if ( root.left != null && !result.contains(root) ) {
                stack.push(root);
                root = root.left;
            } else {
                if (!result.contains(root))
                    result.add(root);
                //System.out.println(root.val);
                if ( root.right != null) {
                    root = root.right;
                } else {
                    try {
                        root = stack.pop();
                        result.add(root);
                    } catch ( EmptyStackException e ) {
                        root = null;
                    }
                }
            }
            /*try{
                System.in.read();
            }catch(Exception e){};*/
        }

        List<Integer> returnResult = new ArrayList<>();
        for ( TreeNode node : result ) {
            System.out.println(node.val);
            returnResult.add(node.val);
        }
        return returnResult;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode one = new TreeNode(10);
        TreeNode two = new TreeNode(5);
        TreeNode three = new TreeNode(-3);
        TreeNode four = new TreeNode(3);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(11);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(-2);
        TreeNode e = new TreeNode(1);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = a;
        three.right = b;
        four.left = c;
        four.right = d;
        a.right = e;

        solution.inorderTraversal(one);

        TreeNode one_1 = new TreeNode(1);
        TreeNode two_1 = new TreeNode(2);
        TreeNode three_1 = new TreeNode(3);
        one_1.right = two_1;
        two_1.left = three_1;

        solution.inorderTraversal(one_1);
    }

    private void printNode(TreeNode node) {
        System.out.println(node.val);
    }
}