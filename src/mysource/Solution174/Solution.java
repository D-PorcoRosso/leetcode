package mysource.Solution174;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        Integer[][] dpTable = new Integer[dungeon.length][dungeon[0].length];
        int min = findMin(dungeon, dpTable, 0, 0);
        if (min > 0)
            return 1;
        return 1-min;
    }
    
    private int findMin(int[][] dungeon, Integer[][] dpTable, int x, int y) {
        int yDir, xDir;
        if (x == dungeon[0].length-1 && y < dungeon.length-1) {
            yDir = findMin(dungeon, dpTable, x, y+1);
            if (dungeon[y][x] + yDir > 0)
                dpTable[y][x] = 0;
            else
                dpTable[y][x] = dungeon[y][x] + yDir;
            return dpTable[y][x];
        }
        if (y == dungeon.length-1 && x < dungeon[0].length-1) {
            xDir = findMin(dungeon, dpTable, x+1, y);
            if (dungeon[y][x] + xDir > 0)
                dpTable[y][x] = 0;
            else
                dpTable[y][x] = dungeon[y][x] + xDir;
        }
        
        if (x == dungeon[0].length-1 && y == dungeon.length-1) {
            dpTable[y][x] = dungeon[y][x] > 0 ? 0 : dungeon[y][x];
            return dpTable[y][x];
        }
        
        if (dpTable[y][x] != null)
            return dpTable[y][x];

        xDir = findMin(dungeon, dpTable, x+1, y);
        yDir = findMin(dungeon, dpTable, x, y+1);
        xDir = xDir > 0 ? 0 : xDir;
        yDir = yDir > 0 ? 0 : yDir;
        dpTable[y][x] = dungeon[y][x] + Math.max(xDir, yDir);
        return dpTable[y][x];
    }
}
