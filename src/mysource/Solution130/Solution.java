package mysource.Solution130;

import java.util.*;
class Solution {
    class point {
        final int x;
        final int y;
        point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if ( ! (o instanceof point ) ) {
                return false;
            }
            point p = (point)o;
            if ( this.x == p.x && this.y == p.y )
                return true;
            return false;
        }
        @Override
        public String toString() {
            return "x:"+x+" y:"+y;
        }
    }
    public void solve(char[][] board) {

        List<point> clean = new LinkedList<>();
        for (int j = 1 ; j < board.length - 1 ; j++ ) {
            for ( int i = 1 ; i < board[0].length - 1 ; i++ ) {
                if ( board[j][i] == 'O' ) {
                    point p;
                    if ( (board[j][i+1] != 'O') && 
                        (board[j][i-1] != 'O') && 
                        (board[j+1][i] != 'O') && 
                        (board[j-1][i] != 'O') ) {
                        p = new point(i,j);
                        if ( !clean.contains(p) )
                            clean.add(p);
                    }
                    if ( ((board[j][i+1] == 'O') && 
                        (board[j][i-1] != 'O') && 
                        (board[j+1][i] == 'O') && 
                        (board[j-1][i] != 'O')) ||
                        ((board[j][i+1] != 'O') && 
                        (board[j][i-1] == 'O') && 
                        (board[j+1][i] == 'O') && 
                        (board[j-1][i] != 'O')) ||
                        ((board[j][i+1] != 'O') && 
                        (board[j][i-1] == 'O') && 
                        (board[j+1][i] != 'O') && 
                        (board[j-1][i] == 'O')) ||
                        ((board[j][i+1] == 'O') && 
                        (board[j][i-1] != 'O') && 
                        (board[j+1][i] != 'O') && 
                        (board[j-1][i] == 'O')) ) {
                        p = new point(i,j);
                        if ( !clean.contains(p) )
                            clean.add(p);
                    }
                    if ( ((board[j][i+1] == 'O') && 
                        (board[j][i-1] != 'O') && 
                        (board[j+1][i] != 'O') && 
                        (board[j-1][i] != 'O')) ||
                        ((board[j][i+1] != 'O') && 
                        (board[j][i-1] == 'O') && 
                        (board[j+1][i] != 'O') && 
                        (board[j-1][i] != 'O')) ||
                        ((board[j][i+1] != 'O') && 
                        (board[j][i-1] != 'O') && 
                        (board[j+1][i] == 'O') && 
                        (board[j-1][i] != 'O')) ||
                        ((board[j][i+1] != 'O') && 
                        (board[j][i-1] != 'O') && 
                        (board[j+1][i] != 'O') && 
                        (board[j-1][i] == 'O')) ) {
                        p = new point(i,j);
                        if ( !clean.contains(p) )
                            clean.add(p);
                    }
                    System.out.println(clean);
                }
            }
        }
        for ( point p : clean ) {
            board[p.y][p.x] = 'X';
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] test1 = {
            { 'X','X','X','X'},
            { 'X','O','O','X'},
            { 'X','X','O','X'},
            { 'X','O','X','X'},
            //{ 'X','O','X','X'}
        };
        solution.solve(test1);
        for (int j = 0 ; j < test1.length ; j++ ) {
            for ( int i = 0 ; i < test1[0].length ; i++ ) {
                System.out.print(test1[j][i]+",");
            }
            System.out.println();
        }
    }
}