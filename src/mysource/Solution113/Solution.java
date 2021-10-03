package mysource.Solution113;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        findPath(root, targetSum, 0, results, new ArrayList<>());
        return results;
    }
    
    private boolean findPath(TreeNode root, int target, int sum, List<List<Integer>> results, List<Integer> result) {
        
        sum += root.val;
        
        if (root.left == null && root.right == null) {
            if(target == sum) {
                result.add(root.val);
                results.add(new ArrayList<>(result));
                result.remove(result.size()-1);
                return true;
            } else
                return false;
        }
        boolean exist = false;
        if (root.left != null) {
            result.add(root.val);
            exist |= findPath(root.left, target, sum, results, result);
            result.remove(result.size()-1);
        }
        if (root.right != null) {
            result.add(root.val);
            exist |= findPath(root.right, target, sum, results, result);
            result.remove(result.size()-1);
        }
        return exist;    
    }
}
