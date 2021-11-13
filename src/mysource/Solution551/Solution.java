package mysource.Solution551;

public class Solution {
    public boolean checkRecord_2021_google(String s) {
        int countA = 0, countL = 0;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            if (s.charAt(i) == 'A') {
                countA++;
                countL = 0;
            } else if (s.charAt(i) == 'L') {
                countL++;
            } else {
                countL = 0;
            }
            if (countA == 2 || countL == 3)
                return false;
        }
        return true;
    }
}
