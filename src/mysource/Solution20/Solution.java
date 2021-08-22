package mysource.Solution20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        char c;
        Stack stack = new Stack();
        for ( int i =0 ; i < length ; i++ ) {
            c = s.charAt(i);
            switch (c) {
                case '{':
                    stack.push(c);
                    break;
                case '}':
                    if ( stack.isEmpty() )
                        return false;
                    if ( !stack.pop().equals('{') )
                        return false;
                    break;
                case '[':
                    stack.push(c);
                    break;
                case ']':
                    if ( stack.isEmpty() )
                        return false; 
                    if ( !stack.pop().equals('[') )
                        return false;
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if ( stack.isEmpty() )
                        return false;
                    if ( !stack.pop().equals('(') )
                        return false;
                    break;
            
                default:
                    break;
            }
        }
        if ( stack.isEmpty() )
            return true;
        return false;
    }

    public boolean isValid_2021(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for ( int index = 0 ; index < length ; index++ ){
            char ch = s.charAt(index);
            char temp = ' ';
            switch(ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty())
                        return false;
                    temp = stack.pop();
                    if (temp != '(')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty())
                        return false;
                    temp = stack.pop();
                    if (temp != '[')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty())
                        return false;
                    temp = stack.pop();
                    if (temp != '{')
                        return false;
                    break;
            }
        } 
        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "asd(){";
        String s2 = "()";
        String s3 = "asd(){}";
        String s4 = "asd(){}}";
        String s5 = "asd(){]";
        String s6 = "asd()[]";
        String s7 = "asd()[";
        String s8 = "([)]";
        String s9 = "([])";
        String s10 = "";
        System.out.println(solution.isValid_2021(s1));
        System.out.println(solution.isValid_2021(s2));
        System.out.println(solution.isValid_2021(s3));
        System.out.println(solution.isValid_2021(s4));
        System.out.println(solution.isValid_2021(s5));
        System.out.println(solution.isValid_2021(s6));
        System.out.println(solution.isValid_2021(s7));
        System.out.println(solution.isValid_2021(s8));
        System.out.println(solution.isValid_2021(s9));
        System.out.println(solution.isValid_2021(s10));
    }
}