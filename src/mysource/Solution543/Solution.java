package mysource.Solution543;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    private int max = 0;

    public int diameterOfBinaryTree_2021_google(TreeNode root) {
        findDepth(root);
        return max;
    }
    
    private int findDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        max = Math.max(max, left+right);
        return 1+Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if ( root != null ) {
            if ( root.left == null && root.right == null)
                return 1;
            int left = 0,right = 0;
            if ( root.left != null)
                left = maxDepth(root.left);
            if ( root.right != null)
                right = maxDepth(root.right);
            if ( left+right > max)
                max = left+right;
            return left > right?left+1: right+1;
        }

        return 0;
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
        
        System.out.println(solution.diameterOfBinaryTree(one));
    }

    private void printNode(TreeNode node) {
        System.out.println(node.val);
    }
}