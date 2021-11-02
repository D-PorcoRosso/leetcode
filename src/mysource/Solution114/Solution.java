package mysource.Solution114;

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

    public void flatten_2021_amz(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        preOrder(root, queue);
        TreeNode returnNode = null, temp = null;
        if (!queue.isEmpty()) {
            returnNode = queue.poll();
            temp = returnNode;
        }
        while(!queue.isEmpty()) {
            temp.right = queue.poll();
            temp.left = null;
            temp = temp.right;
        }
        root = returnNode;
    }
    
    private void preOrder(TreeNode root, Queue<TreeNode> queue) {
        if (root == null)
            return;
        queue.offer(root);
        preOrder(root.left,queue);
        preOrder(root.right,queue);
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