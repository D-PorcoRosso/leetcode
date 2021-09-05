package mysource.Solution102;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> saveList = new HashMap<>();
        BFS(root, saveList, 0);
        List<List<Integer>> results = new ArrayList<>();
        for ( Map.Entry<Integer,List<Integer>> levelOrder : saveList.entrySet() ) {
            results.add(levelOrder.getValue());
        }
        return results;
    }
    
    private void BFS(TreeNode root, HashMap<Integer, List<Integer>> saveList, int level) {
        if (root == null)
            return;
        List<Integer> currentLevel;
        if (saveList.get(level) == null) {
            currentLevel = new ArrayList<>();
            currentLevel.add(root.val);
            saveList.put(level, currentLevel);
        } else {
            currentLevel = saveList.get(level);
            currentLevel.add(root.val);
        }
        int nextLevel = ++level;
        BFS(root.left, saveList, nextLevel);
        BFS(root.right, saveList, nextLevel);
    }
}
