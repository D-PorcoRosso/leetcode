package mysource.Solution463;

class Solution {
    public int islandPerimeter(int[][] grid) {
        int edge = 0;
        if ( grid.length == 0 )
            return 0;
        for ( int i = 0 ; i < grid.length; i++){
            for ( int j = 0 ; j < grid[0].length; j++) {
                int nearCount = 4;
                if ( grid[i][j] == 1 ) {
                    if ( i-1 >= 0 && grid[i-1][j] == 1)
                        nearCount--;
                    if ( i+1 <grid.length && grid[i+1][j] == 1)
                        nearCount--;
                    if ( j-1 >= 0 && grid[i][j-1] == 1)
                        nearCount--;
                    if ( j+1 <grid[0].length && grid[i][j+1] == 1)
                        nearCount--;
                    edge+=nearCount;
                }
            }
        }
        return edge;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] t1 = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] t2 = {{0,1,0,0}};
        int[][] t3 = {};
        int[][] t4 = {{1},{1},{1},{1}};
        System.out.println(solution.islandPerimeter(t1));
        System.out.println(solution.islandPerimeter(t2));
        System.out.println(solution.islandPerimeter(t3));
        System.out.println(solution.islandPerimeter(t4));
    }
}