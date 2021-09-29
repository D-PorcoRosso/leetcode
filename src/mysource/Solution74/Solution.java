package mysource.Solution74;

class Solution {

    public boolean searchMatrix_2021_250(int[][] matrix, int target) {
        int start = 0, end = matrix.length-1, mid = 0;
        while (start <= end) {
            mid = (end-start)/2+start;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] < target) {
                start = mid + 1;
            } else 
                end = mid -1;
        }
        
        int targetRow = start == 0 ? 0 : start-1;
        
        start = 0;
        end = matrix[targetRow].length-1;
        
        while (start <= end) {
            mid = (end-start)/2+start;
            if (matrix[targetRow][mid] == target)
                return true;
            else if (matrix[targetRow][mid] < target) {
                start = mid + 1;
            } else 
                end = mid -1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        if ( n == 0 )
            return false;
        int m = matrix[0].length;
        if ( m == 0 )
            return false;
        
        int row = -1;
        for ( int i = 0 ; i < n ; i++ ) {
            if ( matrix[i][0] <= target && target <= matrix[i][m-1] ) {
                row = i;
                break;
            }
        }
        if ( row == -1 )
            return false;
        int i = 0, j = m-1, mid = 0;
        while( i <= j ) {
            mid = (i+j)/2;
            if ( target == matrix[row][mid] )
                return true;
            else if ( target < matrix[row][mid] )
                j = mid -1;
            else
                i = mid+1;
        }
        return false;
    }

    

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test1 = {
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        System.out.println(solution.searchMatrix(test1, 3));
        System.out.println(solution.searchMatrix(test1, 51));
        System.out.println(solution.searchMatrix(test1, 17));
        System.out.println(solution.searchMatrix(test1, 20));
        System.out.println(solution.searchMatrix(test1, 34));
        int[][] test2 = {{}};
        System.out.println(solution.searchMatrix(test2, 34));
        int[][] test3 = {};
        System.out.println(solution.searchMatrix(test3, 34));
    }
}