package mysource.Solution314;

public class Solution {
    public List<List<Integer>> verticalOrder_2021_amz(TreeNode root) {
        Map<Integer, List<int[]>> mapping = new HashMap<>();
        travesal(root, 0, 0, mapping);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> keySet = new ArrayList<>(mapping.keySet());
        Collections.sort(keySet);
        for ( int key : keySet ) {
            List<int[]> layer = mapping.get(key);
            Collections.sort(layer, new Comparator<int[]>(){
                public int compare(int[] a, int[] b) {
                    return a[0]-b[0];
                }
            });
            List<Integer> result = new ArrayList<>();
            for (int[] l : layer) {
                result.add(l[1]);
            }
            results.add(result);
        }
        return results;
    }
    
    private void travesal(TreeNode root, int currentIndex, int currentLayer, Map<Integer, List<int[]>> mapping) {
        if (root == null)
            return;
        int[] point = new int[2];
        point[0] = currentLayer;
        point[1] = root.val;
        if (mapping.containsKey(currentIndex)) {
            mapping.get(currentIndex).add(point);
        } else {
            List<int[]> result = new ArrayList<>();
            result.add(point);
            mapping.put(currentIndex, result);
        }
        travesal(root.left, currentIndex-1, currentLayer+1, mapping);
        travesal(root.right, currentIndex+1, currentLayer+1, mapping);
    }
}
