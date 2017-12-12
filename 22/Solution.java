import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if ( n == 0 ) {
            return result;
        }
        if ( n == 1 ) {
            result.add("()");
            return result;
        }
        List<String> temp = new ArrayList<>();
        result.add("(())");
        result.add("()()");
        for ( int i = 2 ; i < n ; i++ ) {
            for ( String pattern : result ) {
                temp.add(pattern);
            }
            result.clear();
            for ( String pattern : temp ) {
                char[] patternArray = pattern.toCharArray();
                for ( int index = 0 ; index < patternArray.length ; index++ ) {
                    if ( patternArray[index] == '(' && index == 0 ) {
                        String internal = "("+pattern+")";
                        if ( !result.contains(internal) )
                            result.add(internal);
                        internal = "()"+pattern;
                        if ( !result.contains(internal) )
                            result.add(internal);
                    }
                    if ( index != (patternArray.length - 1) &&
                        patternArray[index] ==')' && 
                        patternArray[index+1] =='(' ) {
                        String internal = "";
                        for ( int tempIndex = 0 ; tempIndex < patternArray.length ; tempIndex++ ) {
                            if ( tempIndex != index )
                                internal += patternArray[tempIndex];
                            else {
                                internal += patternArray[tempIndex];
                                internal += "()";
                            }
                        }
                        if ( !result.contains(internal) )
                            result.add(internal);
                    }
                    if ( patternArray[index] == ')' && index == patternArray.length - 1 ) {;
                        String internal = pattern+"()";
                        if ( !result.contains(internal) )
                            result.add(internal);
                    }
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(4));
        System.out.println(solution.generateParenthesis(5));
    }
}