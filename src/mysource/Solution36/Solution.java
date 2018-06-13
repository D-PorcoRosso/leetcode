
import java.util.*;

class Solution {
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