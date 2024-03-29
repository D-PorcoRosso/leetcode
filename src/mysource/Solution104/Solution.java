package mysource.Solution104;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public int maxDepth_2021_250(TreeNode root) {
        return findDepth(root);
    }
    private int findDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null)
            return 1 + findDepth(root.right);
        else if (root.right == null)
            return 1 + findDepth(root.left);
        return 1 + Math.max(findDepth(root.left), findDepth(root.right)); 
    }

    public int maxDepth_2021(TreeNode root) {
        return DFS(root);
    }
    private int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+ Math.max(DFS(root.left), DFS(root.right));
    }

    public int maxDepth(TreeNode root) {
        if ( root != null ) {
            if ( root.left == null && root.right == null)
                return 1;
            int left = 0,right = 0;
            if ( root.left != null)
                left = maxDepth(root.left);
            if ( root.right != null)
                right = maxDepth(root.right);
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
        
        System.out.println(solution.maxDepth(one));
    }

    private void printNode(TreeNode node) {
        System.out.println(node.val);
    }
}