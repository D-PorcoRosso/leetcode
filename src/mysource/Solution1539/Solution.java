package mysource.Solution1539;

public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int arrIndex = 0;
        int latestNum = arr[arr.length-1] + k;
        for ( int i = 1 ; i <= latestNum ; i++ ) {
            if (arrIndex >= arr.length  || arr[arrIndex] != i) {
                k--;
            } else {
                arrIndex++;
            }
            if (k == 0)
                return i;
        }
        return latestNum;
    }
}
