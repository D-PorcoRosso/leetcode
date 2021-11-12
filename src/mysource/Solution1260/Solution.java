package mysource.Solution1260;

public class Solution {
    public List<List<Integer>> shiftGrid_google(int[][] grid, int k) {
        if (k > grid.length*grid[0].length) {
            k = k % (grid.length*grid[0].length);
        }
        int[] oriArray = new int[grid.length*grid[0].length];
        for ( int i = 0 ; i < grid.length ; i++ ) {
            for ( int j = 0 ; j < grid[0].length ; j++ ) {
                oriArray[i*grid[0].length+j] = grid[i][j];
            }
        }
        
        int[] shiftArray = new int[oriArray.length];
        int count = oriArray.length, index = count-k;
        while(count > 0) {
            if(index == oriArray.length) {
                index = 0;
            }
            shiftArray[oriArray.length-count] = oriArray[index];
            count--;
            index++;
        }
        
        List<List<Integer>> results = new ArrayList<>();
        for ( int i = 0 ; i < grid.length ; i++ ) {
            List<Integer> result = new ArrayList<>();
            for ( int j = 0 ; j < grid[0].length ; j++ ) {
                result.add(shiftArray[i*grid[0].length+j]);
            }
            results.add(result);
        }
        return results;
    }
}
