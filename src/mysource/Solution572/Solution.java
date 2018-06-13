package mysource.Solution572;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        else if ( (s == null && t != null) || (s != null && t == null) )
            return false;
        boolean left = false , right = false;
        if ( s.val == t.val ) {
            left = isSubtree(s.left, t.left);
            right = isSubtree(s.right, t.right);
            if ( left && right )
                return true;
            else
                return false;
        } else {
            left = isSubtree(s.left, t);
            if (left)
                return true;
            right = isSubtree(s.right, t);
            if ( right)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode one = new TreeNode(4);
        TreeNode two = new TreeNode(4);
        TreeNode three = new TreeNode(7);
        TreeNode four = new TreeNode(1);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(9);

        one.left = two;
        /*one.right = three;
        two.left = four;
        two.right = a;
        three.left = b;
        three.right = c;*/

        TreeNode one_1 = new TreeNode(4);
        TreeNode two_1 = new TreeNode(2);
        TreeNode three_1 = new TreeNode(1);
        //one_1.left = two_1;
        //one_1.right = three_1;

        
        System.out.println(solution.isSubtree(one,one_1));
    }

    private void printNode(TreeNode node) {
        System.out.println(node.val);
    }
}