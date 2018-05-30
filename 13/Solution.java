import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        HashMap<Character, Integer> mapping = new HashMap<>();
        mapping.put('I',1);
        mapping.put('V',5);
        mapping.put('X',10);
        mapping.put('L',50);
        mapping.put('C',100);
        mapping.put('D',500);
        mapping.put('M',1000);
        for ( int i = 0 ; i < s.length() ; i++) {
            int current = mapping.get(s.charAt(i));
            if ( i < s.length() - 1 ) {
                int next = mapping.get(s.charAt(i+1));
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