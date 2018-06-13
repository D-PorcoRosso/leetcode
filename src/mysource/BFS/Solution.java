package mysource.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    public List<TreeNode> BFS(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        BFS(root, result, queue);
        return result;
    }

    private void BFS(TreeNode root, List<TreeNode> list, Queue<TreeNode> queue) {
        if ( root == null )
            return;
        if(list.contains(root))
            return;
        list.add(root);
        if ( root.left != null )
            queue.offer(root.left);
        if ( root.right != null )
            queue.offer(root.right);
        if ( !queue.isEmpty() )
            BFS(queue.poll(), list, queue);
        return;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(7);

        one.left = two;
        one.right = three;
        two.left = four;
        //two.right = a;
        three.left = b;
        three.right = c;
        Solution solution = new Solution();
        List<TreeNode> result = solution.BFS(one);
        for ( TreeNode node : result ) {
            System.out.print(node.val+",");
        }
    }
}