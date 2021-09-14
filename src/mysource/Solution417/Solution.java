package mysource.Solution417;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[][] vPacific = new boolean[heights.length][heights[0].length];
        boolean[][] vAtlantic = new boolean[heights.length][heights[0].length];
        for ( int i = 0 ; i < heights.length ; i++ ) {
            dfs(heights, vPacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, vAtlantic, i, heights[0].length-1, Integer.MIN_VALUE);
        }
        for ( int i = 0 ; i < heights[0].length ; i++ ) {
            dfs(heights, vPacific, 0, i, Integer.MIN_VALUE);
            dfs(heights, vAtlantic, heights.length-1, i, Integer.MIN_VALUE);
        }
        
        for ( int i = 0 ; i < heights.length ; i++ ) {
            for ( int j = 0 ; j < heights[0].length ; j++ ) {
                if (vPacific[i][j] && vAtlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }
    
    int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    private void dfs(int[][] heights, boolean[][] visited, int i, int j, int height) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || visited[i][j] || heights[i][j] < height) 
            return;
    
        visited[i][j] = true;
        for(int[] d : direction) {
            dfs(heights, visited, i+d[0], j+d[1], heights[i][j]);
        }
    }
}
