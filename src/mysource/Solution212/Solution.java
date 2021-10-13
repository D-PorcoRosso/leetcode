package mysource.Solution212;

public class Solution {

    public List<String> findWords_2021_250(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for ( int i = 0 ; i < words.length ; i++ ) {
            for ( int y = 0 ; y < board.length ; y++ ) {
                for ( int x = 0 ; x < board[0].length ; x++ ) {
                    if (isInBoard(board, visited, x, y, words[i], 0)) {
                        if (!results.contains(words[i]))
                            results.add(words[i]);
                    }
                    clearVisited(visited);
                }
            }
        }
        return results;
    }
    
    private void clearVisited(boolean[][] visited) {
        for ( int i = 0 ; i < visited.length ; i++ ) {
            for ( int j = 0 ; j < visited[0].length ; j++ ) {
                visited[i][j] = false;
            }
        }
    }
    
    private boolean isInBoard(char[][] board, boolean[][] visited, int x, int y, String word, int wordIndex) {
        if (x >= board[0].length || x < 0 || y >= board.length || y < 0 || board[y][x] != word.charAt(wordIndex) || visited[y][x])
            return false;
        
        if (wordIndex == word.length()-1)
            return true;
        
        visited[y][x] = true;
        boolean isIn = false;
        isIn |= isInBoard(board, visited, x+1, y, word, wordIndex+1);
        if (isIn) return isIn;
        isIn |= isInBoard(board, visited, x-1, y, word, wordIndex+1);
        if (isIn) return isIn;
        isIn |= isInBoard(board, visited, x, y+1, word, wordIndex+1);
        if (isIn) return isIn;
        isIn |= isInBoard(board, visited, x, y-1, word, wordIndex+1);
        if(!isIn)
            visited[y][x] = false;
        return isIn;
        
    }

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
