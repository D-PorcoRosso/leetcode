package mysource.Solution286;

public class Solution {

    public void wallsAndGates_2021_250(int[][] rooms) {
        for ( int i = 0 ; i < rooms.length ; i++ ) {
            for ( int j = 0 ; j < rooms[0].length ; j++ ) {
                if (rooms[i][j] == 0) {
                    findNearest_2021_250(rooms, j, i, 0);
                }
            }
        }
    }
    
    private void findNearest_2021_250(int[][] rooms, int x, int y, int currentDistance) {
        if (x > rooms[0].length-1 || x < 0 || y > rooms.length-1 || y < 0 || rooms[y][x] == -1)
            return;
        
        rooms[y][x] = Math.min(rooms[y][x], currentDistance);
        
        if (x+1 < rooms[0].length && currentDistance+1 < rooms[y][x+1])
            findNearest_2021_250(rooms, x+1, y, currentDistance+1);
        if (x-1 >= 0 && currentDistance+1 < rooms[y][x-1])
            findNearest_2021_250(rooms, x-1, y, currentDistance+1);
        if (y+1 < rooms.length && currentDistance+1 < rooms[y+1][x])
            findNearest_2021_250(rooms, x, y+1, currentDistance+1);
        if (y-1 >= 0 && currentDistance+1 < rooms[y-1][x])
            findNearest_2021_250(rooms, x, y-1, currentDistance+1);
    }

    public void wallsAndGates_2021_250_TLE(int[][] rooms) {
        //boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        for ( int i = 0 ; i < rooms.length ; i++ ) {
            for ( int j = 0 ; j < rooms[0].length ; j++ ) {
                if (rooms[i][j] == 0) {
                    findNearest(rooms, j, i, 0);
                }
            }
        }
    }
    
    private void findNearest(int[][] rooms, int x, int y, int currentDistance) {
        if (x > rooms[0].length-1 || x < 0 || y > rooms.length-1 || y < 0 || rooms[y][x] == -1 || currentDistance > rooms[y][x])
            return;
        
        rooms[y][x] = Math.min(rooms[y][x], currentDistance);
        
        findNearest(rooms, x+1, y, currentDistance+1);
        findNearest(rooms, x-1, y, currentDistance+1);
        findNearest(rooms, x, y+1, currentDistance+1);
        findNearest(rooms, x, y-1, currentDistance+1);
    }
}
