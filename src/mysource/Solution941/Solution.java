package mysource.Solution941;

public class Solution {
    public boolean validMountainArray_2021_google(int[] arr) {
        if(arr.length < 3)
            return false;
        
        boolean startDecade = false;
        for ( int i = 1 ; i < arr.length ; i++ ) {
            if (startDecade) {
                if ( arr[i] >= arr[i-1])
                    return false;
            } else {
                if ( arr[i] < arr[i-1] ) {
                    if (i == 1)
                        return false;
                    startDecade = true;
                }
                else if (arr[i] == arr[i-1])
                    return false;
            }
        }
        return startDecade;
    }
}
