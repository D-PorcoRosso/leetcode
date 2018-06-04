import java.util.*;

class Solution {
    static class Point {
        public final int x;
        public final int y;
        Point(int x , int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Point> zeroPoint = new LinkedList<>();
        for ( int i = 0 ; i < m ; i++ ) {
            for ( int j = 0 ; j < n ; j++ ) {
                if ( matrix[i][j] == 0 ) {
                    zeroPoint.add(new Point(j,i));
                }
            }
        }

        for ( Point point : zeroPoint ) {
            int i = point.y;
            int j = point.x;
            for ( int x = 0 ; x < n ; x++ ) {
                matrix[i][x] = 0;
            }
            for ( int y = 0 ; y < m ; y++ ) {
                matrix[y][j] = 0;
            }
        } 
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test1 = {
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5}
          };
        solution.setZeroes(test1);
        for ( int i = 0 ; i < test1.length ; i++ ) {
            for ( int j = 0 ; j < test1[0].length ; j++ ) {
                System.out.print(test1[i][j]+",");
            }
            System.out.println();
        }
    }
}