package mysource.Solution296;

public class Solution {
    public int minTotalDistance_2021_250_pass(int[][] grid) {
        List<int[]> point = new ArrayList<>();
        int x_sum = 0, y_sum = 0;
        for (int i = 0 ; i < grid.length ; i++ ) {
            for (int j = 0 ; j < grid[0].length ; j++ ) {
                if (grid[i][j] == 1) {
                    int[] p = new int[2];
                    p[0] = i;
                    p[1] = j;
                    point.add(p);
                    x_sum += j;
                    y_sum += i;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        x_sum /= point.size();
        y_sum /= point.size();
        for (int j = -1 ; j <= 1 ; j++)
        for (int i = 0 ; i < grid.length ; i++ ) {
            int sum = 0;
            for ( int[] p : point ) {
                sum = sum + Math.abs(p[0]-i)+Math.abs(p[1]-x_sum+j);
            }
            min = Math.min(min, sum);
        }
        for (int j = -1 ; j <= 1 ; j++)
        for (int i = 0 ; i < grid[0].length ; i++ ) {
            int sum = 0;
            for ( int[] p : point ) {
                sum = sum + Math.abs(p[0]-y_sum+j)+Math.abs(p[1]-i);
            }
            min = Math.min(min, sum);
        }
        return min;
    }
    public int minTotalDistance_2021_250_TLE(int[][] grid) {
        List<int[]> point = new ArrayList<>();
        for (int i = 0 ; i < grid.length ; i++ ) {
            for (int j = 0 ; j < grid[0].length ; j++ ) {
                if (grid[i][j] == 1) {
                    int[] p = new int[2];
                    p[0] = i;
                    p[1] = j;
                    vggh.add(p);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < grid.length ; i++ ) {
            for (int j = 0 ; j < grid[0].length ; j++ ) {
                int sum = 0;
                for ( int[] p : point ) {
                    sum = sum + Math.abs(p[0]-i)+Math.abs(p[1]-j);
                }
                min = Math.min(min, sum);
            }
        }
        return min;
    }
}
