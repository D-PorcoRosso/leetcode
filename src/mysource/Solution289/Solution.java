package mysource.Solution289;

public class Solution {
    public void gameOfLife_2021_250(int[][] board) {
        int[][] nextBoard = new int[board.length][board[0].length];
        for ( int i = 0 ; i < board.length ; i++ ) {
            for ( int j = 0 ; j < board[0].length ; j++ ) {
                int liveCount = isLive(board, j, i);
                if (board[i][j] == 1) {
                    if (liveCount == 2 || liveCount == 3)
                        nextBoard[i][j] = 1;
                    else
                        nextBoard[i][j] = 0;
                } else {
                    if (liveCount == 3)
                        nextBoard[i][j] = 1;
                    else
                        nextBoard[i][j] = 0;
                }
            }
        }
        
        for ( int i = 0 ; i < board.length ; i++ ) {
            for ( int j = 0 ; j < board[0].length ; j++ ) {
                board[i][j] = nextBoard[i][j];
            }
        }
    }
    
    private int isLive(int[][] board, int x, int y) {
        int liveCount = 0;
        if(x+1 < board[0].length && board[y][x+1] == 1) {
            liveCount++;
        }
        if(y+1 < board.length && board[y+1][x] == 1) {
            liveCount++;
        }
        if(x-1 >= 0 && board[y][x-1] == 1) {
            liveCount++;
        }
        if(y-1 >= 0 && board[y-1][x] == 1) {
            liveCount++;
        }
        
        
        if(x+1 < board[0].length && y+1 < board.length && board[y+1][x+1] == 1) {
            liveCount++;
        }
        if(x-1 >= 0 && y-1 >= 0 && board[y-1][x-1] == 1) {
            liveCount++;
        }
        if(x-1 >= 0 && y+1 < board.length && board[y+1][x-1] == 1) {
            liveCount++;
        }
        if(x+1 < board[0].length && y-1 >= 0 && board[y-1][x+1] == 1) {
            liveCount++;
        }
        
        return liveCount;
    }
}
