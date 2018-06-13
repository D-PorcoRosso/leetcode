package mysource.Solution79;

class Solution {
    public boolean exist(char[][] board, String word) {
        //boolean[][] visited = ;
        for ( int i = 0 ; i < board.length ; i++ )
            for ( int j = 0 ; j < board[0].length ; j++ ) {
                System.out.println("loop:");
                if (isExist(new boolean[board.length][board[0].length], board, word, i,j,0))
                    return true;
            }

        return false;
    }

    private boolean isExist(boolean[][] visited, char[][] board, String word, int i, int j, int index) {
        if ( i >= 0 && i < board.length && j >= 0 && j < board[0].length ) {
            System.out.println(i+":"+j+":"+board[i][j]+" visit:"+visited[i][j]+" index:"+index);
            if ( visited[i][j] )
                return false;
            if ( index == word.length() - 1 ) {
                if ( board[i][j] == word.charAt(index) )
                    return true;
                else
                    return false;
            } else {
                if ( board[i][j] == word.charAt(index) ) {
                    index++;
                    boolean hasVisit = isExist(visited, board, word, i, j+1, index) || 
                        isExist(visited, board, word, i, j-1, index) || 
                        isExist(visited, board, word, i+1, j, index) || 
                        isExist(visited, board, word, i-1, j, index);
                    if ( hasVisit ) visited[i][j] = true;
                    return hasVisit;
                } else {
                    return false;
                }
            }
        } else 
            return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] test1 = 
        {
          {'A','B','D','E'},
          {'S','F','C','S'},
          {'A','D','D','E'}
        };
        //System.out.println(solution.exist(test1, "ABCCED"));
        //System.out.println(solution.exist(test1, "SEE"));
        //System.out.println(solution.exist(test1, "ABCB"));
        char[][] test2 = 
        {
          {'a','b'},
          {'c','d'}
        };
        System.out.println(solution.exist(test2, "acdb"));
        char[][] test3 = 
        {
          {'C','A','A'},
          {'A','A','A'},
          {'B','C','D'}
        };
        //System.out.println(solution.exist(test3, "AAB"));
        char[][] test4 = 
        {
          {'A','B','C','E'},
          {'S','F','E','S'},
          {'A','D','E','E'}
        };
        //System.out.println(solution.exist(test4, "ABCESEEEFS"));
    }
}