package mysource.Solution538;

class Solution {

    int sum = 0;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;

        if ( root.left == null && root.right == null) {
            sum += root.val;
            root.val = sum;
            System.out.println(root.val);
            return root;
        }
        if ( root.right != null)
            convertBST(root.right);
        sum += root.val;
        root.val = sum;
        if ( root.left != null)
            convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode one = new TreeNode(5);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(13);
        TreeNode four = new TreeNode(1);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(9);

        //one.left = two;
        one.right = three;
        /*two.left = four;
        two.right = a;
        three.left = b;
        three.right = c;*/
        
        System.out.println(solution.convertBST(one));
    }

    private void printNode(TreeNode node) {
        System.out.println(node.val);
    }
}