package mysource.Solution305;

public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        char[][] grid = new char[m][n];
        for (int i = 0 ; i < grid.length ; i++)
            for (int j = 0 ; j < grid[0].length ; j++)
                grid[i][j] = '0';
            
        List<Integer> numIslands = new ArrayList<>();
        for ( int i = 0 ; i < positions.length ; i++ ) {
            grid[positions[i][0]][positions[i][1]] = '1';
            int currentCount = numIslands(copyGrid(grid));
            numIslands.add(currentCount);
        }
        return numIslands;
    }
    
    private char[][] copyGrid(char[][] grid) {
        char[][] cpGrid = new char[grid.length][grid[0].length];
        for (int i = 0 ; i < grid.length ; i++)
            for (int j = 0 ; j < grid[0].length ; j++) {
                cpGrid[i][j] = grid[i][j];
            }
        return cpGrid;
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
