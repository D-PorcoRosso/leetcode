import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

        if ( root == null )
            return true;

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        ArrayList<Integer> flatNode = new ArrayList<>();

        bfsQueue.offer(root);

        while(!bfsQueue.isEmpty()) {
            TreeNode node = bfsQueue.poll();
            if ( node != null ) {
                flatNode.add(node.val);
                bfsQueue.offer(node.left);
                bfsQueue.offer(node.right);
            }
        }

        int power2 = 1, sum = 1, index = 0, power2SubIndex = 1;
        for ( ; index < flatNode.size() ; index++ ) {
            try {
                if ( flatNode.get(index) == flatNode.get(power2SubIndex-1) ) {
                    power2SubIndex--;
                } else
                    return false;
            } catch ( IndexOutOfBoundsException e ) {
                return false;
            }
            if ( index != flatNode.size() - 1) {
                if ( index == sum - 1 ) {
                    power2 *= 2;
                    sum += power2;
                    power2SubIndex = sum;
                }
            }
        }
        if ( index != sum )
            return false;

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(3);
        //TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        //TreeNode c = new TreeNode(3);

        one.left = two;
        one.right = three;
        two.left = four;
        //two.right = a;
        three.left = b;
        //three.right = c;

        System.out.println(solution.isSymmetric(one));
    }
}