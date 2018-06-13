package mysource.Solution22;

import java.util.ArrayList;
import java.util.List;
//[,,,,,,,,,,,,]
//["","","","","","","(())(())","","","","","",""]
class Solution {
    public List<String> generateParenthesis(int n) {
        String[] test1 = {};
        String[] test2 = {};

        /*for ( String t : test2 ) {
            int count = 0;
            for ( String y : test1 ) {
                if ( !y.equals(t) )
                    count++;
            }
            if ( count == 131 )
                System.out.println("not in:"+t);
        }*/
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
            temp.clear();
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
                    if ( index != (patternArray.length - 1) &&
                        patternArray[index] =='(' && 
                        patternArray[index+1] ==')' ) {
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
                    if ( index <= (patternArray.length - 3) &&
                        patternArray[index] =='(' && 
                        patternArray[index+1] ==')' &&
                        patternArray[index+2] =='(' && 
                        patternArray[index+3] ==')' ) {
                        String internal = "";
                        for ( int tempIndex = 0 ; tempIndex < patternArray.length ; tempIndex++ ) {
                            if (tempIndex == index) {
                                internal += patternArray[tempIndex];
                                internal += "(";
                            } else if (tempIndex == index+3) {
                                internal += patternArray[tempIndex];
                                internal += ")";
                            } else {
                                internal += patternArray[tempIndex];
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
        //System.out.println(solution.generateParenthesis(3));
        //System.out.println(solution.generateParenthesis(4));
        System.out.println(solution.generateParenthesis(6));
    }
}