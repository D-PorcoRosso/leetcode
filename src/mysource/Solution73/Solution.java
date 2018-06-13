package mysource.Solution73;

import java.util.LinkedList;
import java.util.List;

class Solution {

    /*
        public void setZeroes(int[][] matrix) {
        boolean firstRow=false,firstCol=false;
        int m=matrix[0].length,n=matrix.length;
        
        for(int i=0;i<m;i++)
            if(matrix[0][i]==0)firstRow=true;
        for(int i=0;i<n;i++)
            if(matrix[i][0]==0)firstCol=true;
        //use the firstRow and the firstCol as buffer
        for(int i=1;i<n;i++)
            for(int j=1;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        
        for(int i=1;i<m;i++)
            if(matrix[0][i]==0)
                for(int j=1;j<n;j++)
                    matrix[j][i]=0;
        for(int i=1;i<n;i++)
            if(matrix[i][0]==0)
                for(int j=1;j<m;j++)
                    matrix[i][j]=0;
        
        if(firstRow)for(int i=0;i<m;i++)matrix[0][i]=0;
        if(firstCol)for(int i=0;i<n;i++)matrix[i][0]=0;
    } */

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