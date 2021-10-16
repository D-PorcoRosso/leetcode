package mysource.Solution221;

public class Solution {
    public int maximalSquare_2021_250(char[][] matrix) {
        int max = 0;
        for ( int i = 0 ; i < matrix.length ; i++ ) {
            for ( int j = 0 ; j < matrix[0].length ; j++ ) {
                max = Math.max(max, findSquare(matrix, j, i));
            }
        }
        return max;
    }
    
    private int findSquare(char[][] matrix, int x, int y) {
        if (matrix[y][x] == '0')
            return 0;
        int max = 1, range = 1, targetX, targetY;
        boolean existSquare = true;
        while (existSquare) {
            targetX = x+range;
            targetY = y+range;
            if (targetX >= matrix[0].length || targetY >= matrix.length)
                break;
            for ( int i = y ; i <= targetY ; i++) {
                for ( int j = x ; j <= targetX ; j++) {
                    if (matrix[i][j] == '0') {
                        existSquare = false;
                        break;
                    }
                }
            }
            if (existSquare) {
                max = (range+1)*(range+1);
            }
            range++;
        }
        return max;
    }
}
