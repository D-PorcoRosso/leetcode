import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        ArrayList<Integer> front = new ArrayList<>();
        ArrayList<Integer> back = new ArrayList<>();
        front(root,front);
        back(root,back);



        for ( int index = 0; index < front.size() ; index++ ) {
            if ( front.get(index) != back.get(index) )
                return false;
        }
        return true;
    }

    private void front(TreeNode root, ArrayList<Integer> front) {
        if ( root == null ) {
            front.add(null);
            return;
        }

        front(root.left, front);
        front.add(root.val);
        front(root.right, front);
    }

    private void back(TreeNode root, ArrayList<Integer> back) {
        if (root == null) {
            back.add(null);
            return;
        }
        back(root.right, back);
        back.add(root.val);
        back(root.left, back);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(2);
        TreeNode four = new TreeNode(3);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(3);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = a;
        three.left = b;
        three.right = c;

        System.out.println(solution.isSymmetric(one));
    }
}