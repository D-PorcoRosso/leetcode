package mysource.Solution13;

import java.util.HashMap;
import java.util.Map;

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

    //CM : 900 CD: 400, XC:90, XL:40, IX: 9, IV: 4
    public int romanToInt_2021(String s) {
        
        if ( s == null || s.length() == 0 )
            return 0;
        char[] str = s.toCharArray();
        int result = 0;
        for ( int i = 0 ; i < str.length ; i++ ) {
            if (str[i] == 'M') {
                result += 1000;
            }
            else if (str[i] == 'C') {
                if (i < str.length-1 && str[i+1] == 'M') {
                    i++;
                    result += 900;
                } else if (i < str.length-1 && str[i+1] == 'D') {
                    i++;
                    result += 400;
                } else 
                    result += 100;
            }
            else if (str[i] == 'D') {
                result += 500;
            }
            else if (str[i] == 'X') {
                if (i < str.length-1 && str[i+1] == 'C') {
                    i++;
                    result += 90;
                } else if (i < str.length-1 && str[i+1] == 'L') {
                    i++;
                    result += 40;
                } else 
                    result += 10;
            }
            else if (str[i] == 'I') {
                if (i < str.length-1 && str[i+1] == 'X') {
                    i++;
                    result += 9;
                } else if (i < str.length-1 && str[i+1] == 'V') {
                    i++;
                    result += 4;
                } else 
                    result += 1;
            }
            else if (str[i] == 'L') {
                result += 50;
            }
            else if (str[i] == 'V') {
                result += 5;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
       
        System.out.println(solution.romanToInt("MCMXCIV"));
        System.out.println(solution.romanToInt(""));
        System.out.println(solution.romanToInt("IV"));
    }
}