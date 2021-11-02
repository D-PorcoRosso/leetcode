package mysource.Solution95;

public class Solution {
    public List<TreeNode> generateTrees_2021_amz(int n) {
        return genTrees(1,n);
    }
    
    private List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> fullTree = new ArrayList<>();
        if (start > end) {
            fullTree.add(null);
            return fullTree;
        }
        for (int i = start ; i <= end ; i++) {
            List<TreeNode> left = genTrees(start, i-1);
            List<TreeNode> right = genTrees(i+1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode current = new TreeNode(i);
                    current.left = leftNode;
                    current.right = rightNode;
                    fullTree.add(current);
                }
            }
        }
        return fullTree;
    }
}
