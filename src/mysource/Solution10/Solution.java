import java.util.*;

class Solution {
    Stack<Character> inputs = new Stack<>();
    Stack<Character> patterns = new Stack<>();

    public boolean isMatch(String s, String p) {

        for ( int i = 0 ; i < s.length() ; i++) {
            inputs.push(s.charAt(i));
        }
        for ( int i = 0 ; i < p.length() ; i++) {
            patterns.push(p.charAt(i));
        }

        boolean isMulti = false, isAny = false;
        while(!patterns.empty()) {
            char c = patterns.pop();
            switch(c) {
                case '*':
                    isMulti = true;
                    break;
                case '.':
                    isAny = true;
                    if( !isValidate(c,isMulti,isAny) ) {
                        return false;
                    }
                    isMulti = false;
                    isAny = false;
                    break;
                default:
                    if( !isValidate(c,isMulti,isAny) ) {
                        return false;
                    }
                    isMulti = false;
                    isAny = false;
                    break;
            }
        }
        if (!inputs.empty()) {
            System.out.println("empty");
            return false;
        }
        return true;
    }

    private boolean isValidate(char c, boolean isMulti, boolean isAny) {
        char s = '\u0000';
        //"aaa","ab*a*c*a"
        while(!inputs.empty()) {
            s = inputs.pop();
            System.out.println("c:"+c+" s:"+s+":"+isMulti+":"+isAny);
            if (isMulti) {
                if (!isAny) {
                    if ( s != c ) {
                        inputs.push(s);
                        return true;
                    }
                }
            } else {
                if ( isAny )
                    return true;
                else {
                    if ( s != c ) {
                        return false;
                    } else 
                        return true;
                }
            }
        }
        if (isMulti)
            return true;
        if (s == '\u0000')
            return false;
        return true;
    }

    private void clear() {
        inputs.clear();
        patterns.clear();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*System.out.println(solution.isMatch("aa","a")); // false
        solution.clear();
        System.out.println(solution.isMatch("aaa","aaaa")); // false
        solution.clear();
        System.out.println(solution.isMatch("aa","a*")); // true
        solution.clear();
        System.out.println(solution.isMatch("ab",".*")); // true
        solution.clear();
        System.out.println(solution.isMatch("aab","c*a*b")); // true
        solution.clear();
        System.out.println(solution.isMatch("mississippi","mis*is*p*.")); // false
        solution.clear();*/
        System.out.println(solution.isMatch("aaa","ab*a*c*a")); // true
        solution.clear();
        
    }
}