package mysource.Solution557;

import java.util.Stack;

class Solution {

    public String reverseWords(String s) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for ( int i = 0 ; i < s.length() ; i++ ) {
            char current = s.charAt(i);
            if ( current == ' ' ) {
                String temp = "";
                while ( !stack.isEmpty() ) {
                    temp+= stack.pop();
                }
                temp += ' ';
                result += temp;
            } else {
                stack.push(current);
            }
            if ( i == s.length()-1 ) {
                String temp = "";
                while (!stack.isEmpty()) {
                    temp += stack.pop();
                }
                result += temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }
}