package mysource.Solution226;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public TreeNode invertTree(TreeNode root) {
        if ( root != null ) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            System.out.println(root.val);
            invertTree(root.left);
            invertTree(root.right);
        }

        return root;
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
        
        TreeNode result = solution.invertTree(one);
    }

    private void printNode(TreeNode node) {
        System.out.println(node.val);
    }
}