package mysource.Solution310;

public class Solution {
    public List<Integer> findMinHeightTrees_2021_amz_sol(int n, int[][] edges) {
        List<Integer> results = new ArrayList<>();
        if (n < 2) {
            results.add(0);
            return results;
        }
        
        ArrayList<Set<Integer>> relations = new ArrayList<>();
        for ( int i = 0 ; i < n ; i++)
            relations.add(new HashSet<>());
        
        for ( int[] edge : edges) {
            int start = edge[0], end = edge[1];
            relations.get(start).add(end);
            relations.get(end).add(start);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for ( int i = 0 ; i < n ; i++) {
            if (relations.get(i).size() == 1)
                leaves.add(i);
        }
        int remainNodes = n; 
        while (remainNodes > 2) {
            remainNodes -= leaves.size();
            List<Integer> nextLeaves = new ArrayList<>();
            for ( int l : leaves) {
                int neighbor = relations.get(l).iterator().next();
                relations.get(neighbor).remove(l);
                if (relations.get(neighbor).size() == 1)
                    nextLeaves.add(neighbor);
            }
            leaves = nextLeaves;
        }
        return leaves;
    }
    public List<Integer> findMinHeightTrees_2021_amz_TLE(int n, int[][] edges) {
        List<Integer> results = new ArrayList<>();
        if (n < 2) {
            results.add(0);
            return results;
        }
        Map<Integer, List<Integer>> mapping = new HashMap<>();
        for ( int[] edge : edges ) {
            int a = edge[0], b = edge[1];
            if (mapping.containsKey(a)) {
                mapping.get(a).add(b);
            } else {
                List<Integer> nodes = new ArrayList<>();
                nodes.add(b);
                mapping.put(a, nodes);
            }
            if (mapping.containsKey(b)) {
                mapping.get(b).add(a);
            } else {
                List<Integer> nodes = new ArrayList<>();
                nodes.add(a);
                mapping.put(b, nodes);
            }
        }
        
        HashMap<Integer, Integer> result = new HashMap<>();
        boolean[] visited = new boolean[n];
        int min = Integer.MAX_VALUE;
    
        for ( Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
            int depth = findDepth(mapping, visited, entry.getKey());
            visited = new boolean[n];
            result.put(entry.getKey(), depth);
            min = Math.min(min, depth);
        }
        
        for ( Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue() == min)
                results.add(entry.getKey());
        }
        return results;
    }
    
    private int findDepth(Map<Integer, List<Integer>> mapping, boolean[] visited, int currentNode) {
        visited[currentNode] = true;
        int max = 0;
        for (int node : mapping.get(currentNode)) {
            if (!visited[node])
                max = Math.max(max, findDepth(mapping, visited, node)+1);
        }
        return max;
    }
}
