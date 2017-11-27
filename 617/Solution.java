class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    [1,3,2,5]
[2,1,3,null,4,null,7]

    private void sum(TreeNode result, TreeNode t1, TreeNode t2) {
        if (t1 != null || t2 != null) {

            if (t1 != null && t2 != null)
                result.val = t1.val + t2.val;
            if ( t1 == null )
                result.val = t2.val;
            if ( t2 == null )
                result.val = t1.val;
                        System.out.println(result.val);
            
            result.left = new TreeNode(0);
            result.right = new TreeNode(0);
        }
        if ( t1 == null && t2 == null )
            return;
        else if ( t1 == null ) {
            sum(result.left, null, t2.left);
            sum(result.right, null, t2.right);
        } else if ( t2 == null ) {
            sum(result.left, t1.left, null);
            sum(result.right, t1.right, null);
        } else {
            sum(result.left, t1.left, t2.left);
            sum(result.right, t1.right, t2.right);
        }

    }

    public TreeNode mergeTrees(TreeNode t1,TreeNode t2) {
        TreeNode result = new TreeNode(0);
        sum(result, t1, t2);
    
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(3);
        TreeNode three = new TreeNode(2);
        TreeNode four = new TreeNode(5);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(7);
        one.left = two;
        one.right = three;
        two.left = four;
        a.left = b;
        a.right = c;
        b.right = d;
        c.right =e;
        
        TreeNode result = solution.mergeTrees(one,a);
    }

    private void printNode(TreeNode node) {
        System.out.println(node.val);
    }
}