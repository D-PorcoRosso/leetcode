package mysource.Solution32;

public class Solution {
    public int longestValidParentheses(String s) {
        int index = 0, length = 0;
        while (index < s.length()) {
            for ( int i = index + 2 ; i <= s.length() ; i+=2 ) {
                char[] temp = s.substring(index, i).toCharArray();
                if (isValid(temp)) {
                    if (temp.length > length) {
                        length = temp.length;
                    }
                }
            }
            index++;
        }
        return length;
    }
    
    private boolean isValid(char[] str) {
        Stack<Character> stack = new Stack<>();
        for ( int i = 0 ; i < str.length ; i++ ) {
            switch (str[i]) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (stack.empty())
                        return false;
                    if (stack.pop() != '(')
                        return false;
                    break;
            }
        }
        if (stack.empty())
            return true;
        return false;
    }
}
