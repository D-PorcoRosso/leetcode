package mysource.Solution79;

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] target = word.toCharArray();
        for ( int i = 0 ; i < board.length ; i++ ) {
            for ( int j = 0 ; j < board[0].length ; j++ ) {
                clear(visited);
                if (isVisited(board, visited, target, j, i, 0))
                    return true;
            }
        }
        return false;
    }
    
    private void clear(boolean[][] visited) {
        for ( int i = 0 ; i < visited.length ; i++ ) {
            for ( int j = 0 ; j < visited[0].length ; j++ ) {
                visited[i][j] = false;
            }
        }
    }

    private boolean isVisited(char[][] board, boolean[][] visited, char[] target, int x, int y, int index ) {
        if ( x < 0 || x > board[0].length - 1 || y < 0 || y > board.length - 1 || visited[y][x]  || index > target.length-1 || target[index] != board[y][x] )
            return false;
        if (index == target.length-1 && target[index] == board[y][x])
            return true;
        visited[y][x] = true;
        boolean exist = false;
        index++;
        exist |= isVisited(board, visited, target, x + 1, y, index);
        exist |= isVisited(board, visited, target, x - 1, y, index);
        exist |= isVisited(board, visited, target, x , y + 1, index);
        exist |= isVisited(board, visited, target, x , y - 1, index);
        if (!exist)
            visited[y][x] = false;
        return exist;
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