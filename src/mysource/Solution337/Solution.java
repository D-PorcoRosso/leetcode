package mysource.Solution337;

public class Solution {
    public int rob_2021_250(TreeNode root) {
        int[] result = robWithTree(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] robWithTree(TreeNode root) {
        if (root == null)
            return new int[] {0,0};
        int[] left = robWithTree(root.left);
        int[] right = robWithTree(root.right);
        int rob = root.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {rob, notRob};
    }

    public int rob_2021_250_TLE(TreeNode root) {
        return Math.max(robWithTree(root,false), robWithTree(root,true));
    }
    
    private int robWithTree(TreeNode root, boolean isRob, Map<TreeNode, Integer> map) {
        if (root == null)
            return 0;
        if (map.containsKey(root))
            return map.get(root);
        if (isRob) {
            map.put(root, root.val+robWithTree(root.left, false, map)+robWithTree(root.right, false, map));
            return map.get(root);
        } else 
            map.put(root, rob(root.left)+rob(root.right));
            return map.get(root);
    }
}
