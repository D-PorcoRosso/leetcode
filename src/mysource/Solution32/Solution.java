package mysource.Solution32;

public class Solution {
    public int longestValidParentheses_2021_250(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for ( int i = 0 ; i < s.length() ; i++ ) {
            if ( s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public int longestValidParentheses(String s) {
        int index = 0, length = 0;
        while (index < s.length()) {
            for ( int i = index + 2 ; i <= s.length() ; i+=2 ) {
                if ((i-index) < length) {
                    continue;
                }
                String substring = s.substring(index, i);
                if (substring.startsWith(")")) {
                    break;
                }
                char[] temp = substring.toCharArray();
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
