import java.text.DecimalFormat;
import java.util.*;

class Solution {

    public String multiply(String num1, String num2) {
        
        int num1Length = num1.length(), num2Length = num2.length();
        int[] result = new int[num1Length+num2Length];

        for ( int i = num1Length -1 ; i >=0 ; i-- ) {
            for ( int j = num2Length -1 ; j >= 0 ; j-- ) {
                int p2 =  i+j+1, p1 = i+j;
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = num + result[p2];
                result[p2] = sum%10;
                result[p1] += sum/10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for ( int i = 0 ; i < num1Length + num2Length ; i++ ) {
            if ( !(builder.length() == 0 && result[i] == 0))
                builder.append(result[i]);
        }
        return builder.length() == 0? "0":builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        //System.out.println(solution.multiply("123", "456"));
        System.out.println(solution.multiply("123", "0"));
        //System.out.println(solution.multiply("123", "1"));
        System.out.println(solution.multiply("498828660196", "840477629533"));
        System.out.println(solution.multiply("123456789", "987654321"));
        //6 -> 2111121211
    }
    /*
    */ 
}