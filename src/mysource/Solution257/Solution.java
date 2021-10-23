package mysource.Solution257;

public class Solution {

    public List<String> binaryTreePaths_2021_250_faster(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        findBinaryTreePaths(root, result, "");
        return result;
    }
    
    private void findBinaryTreePaths(TreeNode root, List<String> result, String currentPath) {
        if (currentPath.equals(""))
            currentPath = Integer.toString(root.val);
        else {
            StringBuilder b = new StringBuilder(currentPath);
            b.append("->");
            b.append(Integer.toString(root.val));
            currentPath = b.toString();
        }
        
        if (root.left == null && root.right == null) {
            result.add(currentPath);
            return;
        } else if (root.left == null && root.right != null) {
            findBinaryTreePaths(root.right, result, currentPath);
        } else if (root.left != null && root.right == null) {
            findBinaryTreePaths(root.left, result, currentPath);
        } else {
            findBinaryTreePaths(root.right, result, currentPath);
            findBinaryTreePaths(root.left, result, currentPath);
        }
        
        
        
    }

    public List<String> binaryTreePaths_2021_250(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        findBinaryTreePaths(root, result, "");
        return result;
    }
    
    private void findBinaryTreePaths(TreeNode root, List<String> result, String currentPath) {
        if (currentPath.equals(""))
            currentPath = ""+root.val;
        else
            currentPath = currentPath + "->" + root.val;
        
        if (root.left == null && root.right == null) {
            result.add(currentPath);
            return;
        } else if (root.left == null && root.right != null) {
            findBinaryTreePaths(root.right, result, currentPath);
        } else if (root.left != null && root.right == null) {
            findBinaryTreePaths(root.left, result, currentPath);
        } else {
            findBinaryTreePaths(root.right, result, currentPath);
            findBinaryTreePaths(root.left, result, currentPath);
        }
        
        
        
    }
}
