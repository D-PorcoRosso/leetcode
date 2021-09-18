package mysource.Solution54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder_2021(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int i=0, j=0, howmany = matrix.length*matrix[0].length;
        int direction = 0;
        int boundary_x = matrix[0].length;
        int boundary_init_x = 0;
        int boundary_y = matrix.length;
        int boundary_init_y = matrix.length == 1 ? 0 : 1;
        while(howmany != 0) {
            
            result.add(matrix[i][j]);
            howmany--;
            switch(direction) {
                case 0://right
                    if (j == boundary_x-1) {
                        direction = 1;
                        boundary_x--;
                        i++;
                    } else {
                        j++;
                    }
                    break;
                case 1://down
                    if (i == boundary_y-1) {
                        direction = 2;
                        boundary_y--;
                        j--;
                    } else {
                        i++;
                    }
                    break;
                case 2://left
                    if (j == boundary_init_x) {
                        direction = 3;
                        boundary_init_x++;
                        i--;
                    } else {
                        j--;
                    }
                    break;
                case 3://up
                    if (i == boundary_init_y) {
                        direction = 0;
                        boundary_init_y++;
                        j++;
                    } else {
                        i--;
                    }
                    break;
            }
        }
        return result;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int i = 0 , j = 0 , direction = 1;
        int down = matrix.length;
        if ( down == 0)
            return result;
        int right = matrix[0].length, left = 0, up = 0;
        boolean[][] visited = new boolean[down][right];
        int count = right*down;
        if (count == 1) {
            result.add(matrix[0][0]);
            return result;
        }
        while(count > 0) {
            if ( !visited[j][i] ) {
                result.add(matrix[j][i]);
                visited[j][i] = true;
                count--;
                switch(direction) {
                    case 1:
                        i++;
                        break;
                    case 2:
                        j++;
                        break;
                    case 3:
                        i--;
                        break;
                    case 4:
                        j--;
                        break;
                }
                if ( i == right) {
                    i--;
                    j++;
                    direction = 2;
                }
                if ( j == down ) {
                    j--;
                    i--;
                    direction = 3;
                }
                if ( i == -1 ) {
                    i++;
                    j--;
                    direction = 4;
                }
            }
            switch(direction) {
                case 1:
                    if( visited[j][i] ) {
                        direction = 2;
                        i--;j++;
                    }
                    break;
                case 2:
                    if( visited[j][i] ) {
                        direction = 3;
                        i--;j--;
                    }
                    break;
                case 3:
                    if( visited[j][i] ) {
                        direction = 4;
                        i++;j--;
                    }
                    break;
                case 4:
                    if( visited[j][i] ) {
                        direction = 1;
                        i++;j++;
                    }
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] t1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12}
          };
        
        System.out.println(solution.spiralOrder(t1));

        int[][] t2 = {
            {1, 2, 3, 4, 5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20}
          };
        System.out.println(solution.spiralOrder(t2));
        int[][] t3 = {
            {1,3,4},
            {5,6,7}
          };
        System.out.println(solution.spiralOrder(t3));
        int[][] t4 = {
            {1,2,3,4}
          };
        System.out.println(solution.spiralOrder(t4));
        int[][] t5 = {
            {1},
            {2},
            {3}
          };
        System.out.println(solution.spiralOrder(t5));
        int[][] t6 = {
            {1}
          };
        System.out.println(solution.spiralOrder(t6));
        int[][] t7 = {
            {1},
            {2}
          };
        System.out.println(solution.spiralOrder(t7));
        int[][] t8 = {};
        System.out.println(solution.spiralOrder(t8));
    }
}