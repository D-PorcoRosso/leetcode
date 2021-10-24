package mysource.Solution261;

public class Solution {
    public boolean validTree_2021_250(int n, int[][] edges) {
        Integer[] relations = new Integer[n];
        for ( int i = 0 ; i < edges.length ; i++ ) {
            int start = find(relations, edges[i][0]);
            int end = find(relations, edges[i][1]);
            
            if (start == end) return false;
            relations[start] = end;
        }
        return edges.length == n-1;
    }
    
    private int find(Integer[] relations, int index) {
        if (relations[index] == null) return index;
        return find(relations, relations[index]);
    }

    public boolean validTree(int n, int[][] edges) {
        if ( edges.length != (n - 1) )
            return false;
        
        if ( n == 1 )
            return true;
        
        for ( int[] edge : edges ) {
            if (edge[0] > edge[1]) {
                int temp = edge[0];
                edge[0] = edge[1];
                edge[1] = temp;
            }
        }
        
        Arrays.sort(edges, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        List<Integer> connection = new ArrayList<>();
        connection.add(edges[0][0]);
        connection.add(edges[0][1]);
        List<Integer> tempNotIn = new ArrayList<>();
        
        for ( int i = 1 ; i < edges.length ; i++ ) {
            if (!connection.contains(edges[i][0]) && !connection.contains(edges[i][1])) {
                tempNotIn.add(i);
            }
            if (connection.contains(edges[i][0]) && !connection.contains(edges[i][1]))
                connection.add(edges[i][1]);
            if (!connection.contains(edges[i][0]) && connection.contains(edges[i][1]))
                connection.add(edges[i][0]);
        }
        
        
         while (tempNotIn.size() != 0) {
            int index = 0;
            int temp = tempNotIn.size();
            boolean isRemove = false;
            for ( int i = 0 ; i < tempNotIn.size() ; i++) {
                index = tempNotIn.get(i);
                if (connection.contains(edges[index][0]) && !connection.contains(edges[index][1])) {
                    connection.add(edges[index][1]);
                    index = i;
                    isRemove = true;
                    break;
                }
                if (!connection.contains(edges[index][0]) && connection.contains(edges[index][1])) {
                    connection.add(edges[index][0]);
                    isRemove = true;
                    index = i;
                    break;
                }
            }
            if (isRemove)
                tempNotIn.remove(index);
            else {
                break;
            }
        }
        
        if (connection.size() != n)
            return false;
        return true;
    }
}
