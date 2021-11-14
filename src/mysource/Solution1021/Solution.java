package mysource.Solution1021;

public class Solution {
    public String removeOuterParentheses_2021_google(String s) {
        Stack<Character> stack = new Stack();
        int start = 0;
        StringBuilder builder = new StringBuilder();
        for ( int i = 0 ; i < s.length() ; i++ ) {
            if(i != 0 && stack.isEmpty()) {
                builder.append(s.substring(start+1, i-1));
                start = i;
            }
            if(s.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
            }
        }
        builder.append(s.substring(start+1, s.length()-1));
        return builder.toString();
    }
}
