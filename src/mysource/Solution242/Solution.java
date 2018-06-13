package mysource.Solution242;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        System.out.println(s.length()+":"+t.length());
        if ( s.length() != t.length() )
            return false;
        HashMap<Character ,Integer> forS = genAccumulate(s);
        HashMap<Character ,Integer> forT = genAccumulate(t);
        for ( Map.Entry<Character, Integer> exam : forS.entrySet() ) {
            if (forT.get(exam.getKey()) == null)
                return false;
            int tValue = forT.get(exam.getKey());
            if ( (int)exam.getValue() != tValue)
                return false;
        }
        return true;
    }

    private HashMap<Character ,Integer> genAccumulate(String s) {
        HashMap<Character ,Integer> result = new HashMap<>();
        for ( int i = 0 ; i < s.length() ; i++ ) {
            Character c = s.charAt(i);
            if ( result.get(c) != null ) {
                int count = result.get(c);
                result.put(c, ++count);
            } else
                result.put(c, 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("test","estt"));

    }
}