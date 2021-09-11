package mysource.Solution212;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for ( int i = 0 ; i < words.length ; i++) {
            if (isInBoard(board, words[i])) {
                result.add(words[i]);
            }
        }
        return result;
    }
    
    private int[][] createVisited(char[][] board) {
        int[][] v = new int[board.length][board[0].length];
        for ( int i = 0 ; i < board.length ; i++ ) {
            for (int j = 0 ; j < board[0].length ; j++ ) {
                v[i][j] = 0;
            }
        }
        return v;
    }
    
    private int[][] clearVT(int[][] t) {
        for ( int i = 0 ; i < t.length ; i++ ) {
            for (int j = 0 ; j < t[0].length ; j++ ) {
                t[i][j] = 0;
            }
        }
        return t;
    }
    
    private boolean isInBoard(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        int[][] visitedTable = createVisited(board);
        int index = 0;
        for ( int i = 0 ; i < board.length ; i++ ) {
            for (int j = 0 ; j < board[0].length ; j++ ) {
                index = 0;
                visitedTable = clearVT(visitedTable);
                if (isIn(board, visitedTable, i, j , i, j,wordArray, index))
                    return true;
            }
        }
        return false;
    }
    
    private boolean isIn(char[][] board, int[][] vt, int i, int j, int preI, int preJ, char[] wordArray, int index) {
        if ( i < 0 || i > board.length - 1 || j < 0 || j > board[0].length -1 || vt[i][j] == 1) return false;
        boolean isTrue = false;
        if (board[i][j] == wordArray[index]) {
            if (index == wordArray.length-1)
                return true;
            vt[i][j] = 1;
            ++index;
            if (j-1 != preJ)
                isTrue = isTrue || isIn(board, vt, i, j-1, i, j, wordArray, index);
            if (j+1 != preJ)
                isTrue = isTrue || isIn(board, vt, i, j+1, i, j, wordArray, index);
            if (i-1 != preI)
                isTrue = isTrue || isIn(board, vt, i-1, j, i, j, wordArray, index);
            if (i+1 != preI)
                isTrue = isTrue || isIn(board, vt, i+1, j, i, j, wordArray, index);
            if (!isTrue)
                vt[i][j] = 0;
            return isTrue;
        } else {
            return false;
        }
    }
}
