package mysource.Solution200;

public class Solution {
    private int count = 0;
    
    public int numIslands_2021_250(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for ( int i = 0 ; i < grid.length ; i++ ) {
            for ( int j = 0 ; j < grid[0].length ; j++ ) {
                if (existIsland(grid, visited, j, i)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean existIsland(char[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || grid[y][x] == '0' || visited[y][x])
            return false;
        visited[y][x] = true;
        existIsland(grid, visited, x+1, y);
        existIsland(grid, visited, x-1, y);
        existIsland(grid, visited, x, y+1);
        existIsland(grid, visited, x, y-1);
        return true;
    }


    public int numIslands(char[][] grid) {
        int count = 0;
        
        for ( int m = 0 ; m < grid.length ; m++ ) {
            for (int n = 0 ; n < grid[0].length ; n++ ) {
                if (grid[m][n] == '1') {
                    markIslands(grid, m, n);
                    ++count;
                }
            }
        }
        return count;
    }
    
    private void markIslands(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        markIslands(grid, i-1, j);
        markIslands(grid, i+1, j);
        markIslands(grid, i, j-1);
        markIslands(grid, i, j+1);
    }
    
}
