package mysource.Solution107;

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null )
            return result;

        Queue<TreeNode> initQueue = new LinkedList<>();
        initQueue.add(root);
        collect(initQueue, result);
        List<List<Integer>> reverse = new ArrayList<>();
        for ( int i = result.size() - 1 ; i >= 0 ; i-- ) {
            reverse.add(result.get(i));
        }
        return reverse;
    }

    private void collect( Queue<TreeNode> inputQueue, List<List<Integer>> result ) {
        if (inputQueue.isEmpty())
            return;
        Queue<TreeNode> tempQueue = new LinkedList<>();
        List<Integer> layerResult = new ArrayList<>(); 
        while(!inputQueue.isEmpty()) {
            TreeNode node = inputQueue.poll();
            if ( node != null ) {
                layerResult.add(node.val);
                if ( node.left != null )
                    tempQueue.add(node.left);
                if ( node.right != null )
                    tempQueue.add(node.right);
            }
        }
        result.add(layerResult);
        collect(tempQueue, result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(2);
        //TreeNode four = new TreeNode(3);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(3);
        //TreeNode c = new TreeNode(3);

        one.left = two;
        one.right = three;
        //two.left = four;
        two.right = a;
        three.left = b;
        //three.right = c;

        System.out.println(solution.levelOrderBottom(one));
    }
}