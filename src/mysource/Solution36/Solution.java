package mysource.Solution36;

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku_2021_250(char[][] board) {
        List<Character> container = new ArrayList<>();
        for ( int i = 0 ; i < board.length ; i++ ) {
            for ( int j = 0 ; j < board[0].length ; j++ ) {
                if (board[i][j] == '.')
                    continue;
                if (container.contains(board[i][j]))
                    return false;
                container.add(board[i][j]);
            }
            container.clear();
        }
        container.clear();
        for ( int i = 0 ; i < board[0].length ; i++ ) {
            for ( int j = 0 ; j < board.length ; j++ ) {
                if (board[j][i] == '.')
                    continue;
                if (container.contains(board[j][i]))
                    return false;
                container.add(board[j][i]);
            }
            container.clear();
        }
        container.clear();
        for ( int i = 0 ; i < board.length ; i+=3 ) {
            for ( int j = 0 ; j < board[0].length ; j+=3 ) {
                for ( int k = i ; k < i+3 ; k++ ) {
                    for ( int l = j ; l < j+3 ; l++ ) {
                        if (board[k][l] == '.')
                            continue;
                        if (container.contains(board[k][l]))
                            return false;
                        container.add(board[k][l]);
                    }
                }
                container.clear();
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> mapping = new HashSet<>();
        for ( int i = 0 ; i < 9 ; i++ ) {
            for ( int j = 0 ; j < 9 ; j++ ) {
                char c = board[i][j];
                if ( c != '.')
                    if ( mapping.contains(c) )
                        return false;
                    mapping.add(c);
            }
            mapping.clear();
        }

        for ( int i = 0 ; i < 9 ; i++ ) {
            for ( int j = 0 ; j < 9 ; j++ ) {
                char c = board[j][i];
                if ( c != '.')
                    if ( mapping.contains(c) )
                        return false;
                    mapping.add(c);
            }
            mapping.clear();
        }

        for ( int i = 0 ; i < 9 ; i+=3 ) {
            for ( int j = 0 ; j < 9 ; j+=3 ) {
                for ( int k = i ; k < i+3 ; k++ ) {
                    for ( int l = j ; l < j+3 ; l++ ) {
                        char c = board[k][l];
                        if ( c != '.')
                            if ( mapping.contains(c) )
                                return false;
                            mapping.add(c);
                    }
                }
                mapping.clear();
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] test1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
          };
        System.out.println(solution.isValidSudoku(test1));
        char[][] test2 = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
          };
        System.out.println(solution.isValidSudoku(test2));
    }
}