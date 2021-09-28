package mysource.Solution59;

class Solution {
    public int[][] generateMatrix_2021_250(int n) {
        int[][] matrix = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        if (n == 1) {
            matrix[0][0] = 1;
            return matrix;
        }
            
        int count = 1, x = 0, y = 0;
        int direction = 1; // 1 : > , 2 : v , 3 : < , 4 : ^
        while (count <= n*n) {
            matrix[y][x] = count++;
            visited[y][x] = true;
            switch(direction) {
                case 1:
                    x++;
                    if (x == n-1)
                        direction = 2;
                    if(visited[y][x]) {
                        direction = 2;
                        x--;
                        y++;
                    }
                    break;
                case 2:
                    y++;
                    if(visited[y][x]) {
                        direction = 3;
                        y--;
                        x--;
                    }   
                    if (y == n-1){
                        direction = 3;
                    }
                    break;
                case 3:
                    x--;
                    if(visited[y][x]) {
                        direction = 4;
                        x++;
                        y--;
                    }
                    if (x == 0){
                        direction = 4;
                    }
                    break;
                case 4:
                    y--;
                    if(visited[y][x]){
                        direction = 1;
                        y++;
                        x++;
                    }
                    if (y == 0){
                        direction = 1;
                    }
                    break;
            }
        }
        return matrix;
    }

    public int[][] generateMatrix(int n) {
        int[][] martix = new int[n][n];
        int i = 0 , j = 0 , direction = 1;
        int down = n;
        if ( n == 0) {
            return martix;
        }
        if (n == 1) {
            martix[0][0] = 1;
            return martix;
        }
        int right = n, left = 0, up = 0;

        int count = 1;

        while(count <= n*n) {
            if ( martix[j][i] == 0 ) {
                martix[j][i]=count;
                count++;
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
                    if( martix[j][i] != 0 ) {
                        direction = 2;
                        i--;j++;
                    }
                    break;
                case 2:
                    if( martix[j][i] != 0 ) {
                        direction = 3;
                        i--;j--;
                    }
                    break;
                case 3:
                    if( martix[j][i] != 0 ) {
                        direction = 4;
                        i++;j--;
                    }
                    break;
                case 4:
                    if( martix[j][i] != 0 ) {
                        direction = 1;
                        i++;j++;
                    }
                    break;
            }
        }
        return martix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int[][] t1 = solution.spiralOrder(1);
        for( int i = 0 ; i < t1.length ; i++) {
            for( int j = 0 ; j < t1.length ; j++) {
                System.out.print(t1[i][j]+",");
            }
            System.out.println("\n");
        }
        

        int[][] t2 = solution.spiralOrder(2);
        for( int i = 0 ; i < t2.length ; i++) {
            for( int j = 0 ; j < t2.length ; j++) {
                System.out.print(t2[i][j]+",");
            }
            System.out.println("\n");
        }

        int[][] t3 = solution.spiralOrder(4);
        for( int i = 0 ; i < t3.length ; i++) {
            for( int j = 0 ; j < t3.length ; j++) {
                System.out.print(t3[i][j]+",");
            }
            System.out.println("\n");
        }

        int[][] t4 = solution.spiralOrder(0);
        for( int i = 0 ; i < t4.length ; i++) {
            for( int j = 0 ; j < t4.length ; j++) {
                System.out.print(t4[i][j]+",");
            }
            System.out.println("\n");
        }*/
    }
}