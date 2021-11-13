package mysource.Solution557;

import java.util.Stack;

class Solution {

    public String reverseWords_2021_google(String s) {
        String[] strs = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < strs.length ; i++) {
            char[] array = strs[i].toCharArray();
            for (int j = 0 ; j < array.length/2 ; j++) {
                char temp = array[j];
                array[j] = array[array.length-1-j];
                array[array.length-1-j] = temp;
            }
            for (int j = 0 ; j < array.length ; j++) {
                builder.append(array[j]);
            }
            if (i != strs.length-1)
                builder.append(' ');
        }
        return builder.toString();
    }

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