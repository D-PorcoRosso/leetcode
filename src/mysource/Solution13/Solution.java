import java.util.*;

class Solution {

    private static Map<Character, Integer> mapping = new HashMap(){
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };
    public int romanToInt(String s) {
        
        if ( s == null || s.length() == 0 )
            return 0;
        char[] array = s.toCharArray();
        int sum = mapping.get(array[array.length-1]);
        int pre = sum;
        for ( int i = array.length - 2 ; i >= 0 ; i--) {
            int current = mapping.get(array[i]);
            if ( pre > current ) 
                sum -= current;
            else
                sum += current;
            pre = current;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
       
        System.out.println(solution.romanToInt("MCMXCIV"));
        System.out.println(solution.romanToInt(""));
        System.out.println(solution.romanToInt("IV"));
    }
}