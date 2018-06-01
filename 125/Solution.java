import java.util.*;
class Solution {
    public boolean isPalindrome(String s) {
        List<Character> character = new LinkedList<>();
        for ( int i = 0 ; i < s.length() ; i++ ) {
            char c = s.charAt(i);
            if ( (c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || (c <='9' && c>='0'))
                character.add(c);
        }
        System.out.println(character);
        int length = character.size();
        for ( int i = 0 ; i < length/2 ; i++ ) {
            if( Character.toLowerCase(character.get(i)) != 
                Character.toLowerCase(character.get(length-1-i)) )
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
    }
}