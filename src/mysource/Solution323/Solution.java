package mysource.Solution323;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> mapping = new HashMap<>();
        for ( int i = 0 ; i < edges.length ; i++ ) {
            addNode(mapping, edges[i][0], edges[i][1]);
            addNode(mapping, edges[i][1], edges[i][0]);
        }
        
        int count = 0;
        for (int i = 0 ; i < edges.length ; i++ ) {
            if (!visited[edges[i][0]]) {
                visited[edges[i][0]] = true;
                dfs(mapping, visited, edges[i][0]);
                count++;
            }
        }
        
        int notVisited = 0;
        for ( int i = 0 ; i < n ; i++ ) {
            if (!visited[i])
                ++notVisited;
        }
        return count+notVisited;
    }
    
    private void dfs(HashMap<Integer, List<Integer>> mapping, boolean[] visited, int start) {
        for (int end : mapping.get(start)) {
            if (!visited[end]) {
                visited[end] = true;
                dfs(mapping, visited, end);
            }
        }
    }
    
    private void addNode(HashMap<Integer, List<Integer>> mapping, int start, int end) {
        List<Integer> list = null;
        if (mapping.get(start) == null) {
            list = new ArrayList<>();
            list.add(end);
            mapping.put(start, list);
        } else {
            list = mapping.get(start);
            if (!list.contains(end)) {
                list.add(end);
            }
        }
    }
}
