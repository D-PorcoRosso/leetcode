package mysource.Solution277;

public class Solution {
    public int findCelebrity_2021_250_faster(int n) {
        int celebrityIndex = 0;
        for (int i = 1 ; i < n ; i++) {
            if (knows(celebrityIndex, i))
                celebrityIndex = i;
        }
        
        for (int i = 0 ; i < n ; i++) {
            if (i != celebrityIndex && (knows(celebrityIndex, i) || !knows(i, celebrityIndex))) return -1;
        }
        return celebrityIndex;
    }
    public int findCelebrity_2021_250(int n) {
        int[][] relations = new int[n][n];
        for ( int i = 0 ; i < n ; i++ ) {
            for ( int j = 0 ; j < n ; j++ ) {
                relations[i][j] = knows(i, j) ? 1 : 0;
            }
        }
        int celebrityIndex = -1;
        for ( int i = 0 ; i < n ; i++ ) {
            int count = 0;
            for (int j = 0 ; j < n ; j++) {
                if(relations[i][j] == 1) {
                    count++;
                    if (count > 1)
                        break;
                }
            }
            if (count == 1) 
                celebrityIndex = i;
        }
        if (celebrityIndex == -1)
            return -1;
        
        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            if(i != celebrityIndex && relations[i][celebrityIndex] == 1)
                count++;
        }
        return count == n-1 ? celebrityIndex : -1;
    }
}
