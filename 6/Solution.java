import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
        String[] temp = new String[numRows];
        Arrays.fill(temp,"");
        String result = "";
        int index = 0 ;
        boolean positive = true;

        for ( int i = 0 ; i < s.length() ; i++ ) {
            if ( positive ) {
                temp[index] += s.charAt(i);
                if ( numRows > 1 ) {
                    index++;
                    if ( index == numRows - 1 ) {
                        positive = false;
                    }
                }
            } else {
                temp[index] += s.charAt(i);
                if ( numRows > 1 ) {
                    index--;
                    if ( index == 0 )
                        positive = true;
                }
            }
        }
        for ( String t : temp ) {
            result += t;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING",3));
        System.out.println(solution.convert("PAYPALISHIRING",4));
        System.out.println(solution.convert("PAYPALISHIRING",5));
        System.out.println(solution.convert("PAYPALISHIRING",13));
        System.out.println(solution.convert("PAYPALISHIRING",100));
        System.out.println(solution.convert("AB",1));
        System.out.println(solution.convert("ABCD",2));
    }
}