package mysource.Solution48;

class Solution {

    public void rotate(int[][] matrix) {
        int length = matrix[0].length;
        for ( int i = 0 ; i < length ; i++ ) {
            for ( int j = i ; j < length ; j++ ) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for ( int i = 0 ; i < length ; i++ ) {
            for ( int j = 0 ; j < length/2 ; j++ ) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length-j-1];
                matrix[i][length-j-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test1 = {
            { 5, 1, 9,11},
            { 2, 4, 8,10},
            {13, 3, 6, 7},
            {15,14,12,16}
          };
        solution.rotate(test1);
        for ( int i = 0 ; i < test1[0].length ; i++ ) {
            for ( int j = 0 ; j < test1[0].length ; j++ ) {
                System.out.print(test1[i][j]+",");
            }
            System.out.print("\n");
        }
        //6 -> 2111121211
    }
    /*
    */ 
}