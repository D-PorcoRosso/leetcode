package mysource.Solution848;

public class Solution {
    public String shiftingLetters_2021_google(String s, int[] shifts) {
        char[] array = s.toCharArray();
        long[] shiftsLong = new long[shifts.length];
        shiftsLong[shifts.length-1] = shifts[shifts.length-1];
        for ( int i = shifts.length-2 ; i >= 0 ; i-- ) {
            shiftsLong[i] = shiftsLong[i+1]+shifts[i];
        }
        
        for ( int j = 0 ; j < array.length ; j++ ) {
            int c = (int)array[j]+(int)(shiftsLong[j]%26);
            if(c > (int)'z'){
                c = c-26;
            }
            array[j] = (char)c;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < array.length ; i++)
            builder.append(array[i]);
        return builder.toString();
    }
}
