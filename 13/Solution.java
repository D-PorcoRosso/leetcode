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
        int sum = 0;
        char[] array = s.toCharArray();
        for ( int i = 0 ; i < array.length ; i++) {
            int current = mapping.get(array[i]);
            if ( i < s.length() - 1 ) {
                int next = mapping.get(array[i+1]);
                if (current < next) {
                    sum += (next - current);
                    i++;
                    continue;
                }
            }
            sum += current;
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