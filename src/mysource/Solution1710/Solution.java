package mysource.Solution1710;

public class Solution {
    public int maximumUnits_2021_250(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[1]-a[1];
            }
        });
        int max = 0;
        for ( int i = 0 ; i < boxTypes.length ; i++ ) {
            if (truckSize > boxTypes[i][0]) {
                truckSize -= boxTypes[i][0];
                max += boxTypes[i][0]*boxTypes[i][1];
            } else {
                max += truckSize*boxTypes[i][1];
                break;
            }
        }
        return max;
    }
}
