package mysource.Solution437;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    private int initSum=0;
    public int pathSum(TreeNode root, int sum) {
        int count = 0;
        return countFunction(root, sum);
    }

    private int countFunction(TreeNode root, int sum) {
        if ( root == null )
            return 0;
        
        int total = 0;
        /*System.out.println(root.val);
        System.out.println(sum);
        System.out.println(total);
        try {
            System.in.read();
        } catch ( Exception e){}*/

        if (root.val > sum) {
            total = countFunction(root.left, initSum) 
            + countFunction(root.right, initSum);
        } else if (root.val == sum) {
            total = countFunction(root.left, sum - root.val) 
            + countFunction(root.right, sum - root.val)
            + 1;
        } else {
            total = countFunction(root.left, sum - root.val) 
            + countFunction(root.right, sum - root.val);
        }

        return total;
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
        solution.initSum = 8;
        
        System.out.println(solution.pathSum(one, solution.initSum));
    }

    private void printNode(TreeNode node) {
        System.out.println(node.val);
    }
}