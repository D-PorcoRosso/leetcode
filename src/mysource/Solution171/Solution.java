package mysource.Solution171;

public class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for ( int i = 0 ; i < columnTitle.length() ; i++ ) {
            int num = columnTitle.charAt(i)-'A'+1;
            sum += (num*Math.pow(26,columnTitle.length()-i-1));
        }
        return sum;
    }
}
