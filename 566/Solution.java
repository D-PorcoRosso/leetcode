import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[] temp = new int[r*c];
        int count = 0;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            for ( int j = 0 ; j < nums[0].length ; j++ ) {
                temp[count] = nums[i][j];
                count++;
            }
        }
        count = 0;
        int[][] result = new int[r][c];
        for ( int i = 0 ; i < r ; i++ ) {
            for ( int j = 0 ; j < c ; j++ ) {
                result[i][j] = temp[count];
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test1 = { {1,2}, {3,4}};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(test1[i][j] + ",");
            }
            System.out.print("\n");
        }
        int[][] testResult = solution.matrixReshape(test1, 1, 4);
        for ( int i = 0 ; i < 1 ; i++ ) {
            for ( int j = 0 ; j < 4 ; j++ ) {
                System.out.print(testResult[i][j]+",");
            }
            System.out.print("\n");
        }
        int[][] testResult2 = solution.matrixReshape(test1, 2, 4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(testResult2[i][j] + ",");
            }
            System.out.print("\n");
        }
    }
}