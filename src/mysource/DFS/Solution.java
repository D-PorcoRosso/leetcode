package mysource.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> DFS(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        DFS(root, result, stack);
        return result;
    }

    private void DFS(TreeNode root, List<TreeNode> list, Stack<TreeNode> stack) {
        if ( root == null )
            return;
        if(list.contains(root))
            return;
        list.add(root);
        if ( root.left == null && root.right == null ) {
            if (!stack.isEmpty())
                DFS(stack.pop(), list, stack);
            else
                return;
        } else if ( root.left != null && root.right == null ) {
            DFS(root.left, list, stack);
        } else if ( root.left == null && root.right != null ) {
            DFS(root.right, list, stack);
        } else {
            stack.push(root.right);
            DFS(root.left, list, stack);
        }
        return;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(7);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = a;
        three.left = b;
        three.right = c;
        Solution solution = new Solution();
        List<TreeNode> result = solution.DFS(one);
        for ( TreeNode node : result ) {
            System.out.print(node.val+",");
        }
    }
}