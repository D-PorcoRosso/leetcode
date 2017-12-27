import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Character> count = new Stack<>(), content = new Stack<>();
        String result = "";
        for ( int i = 0 ; i < s.length() ; i++ ) {
            char c = s.charAt(i);
            System.out.println(c);
            if ( Character.isDigit(c)) {
                count.push(c);
            } else {
                if ( c == ']' ) {
                    char popC;
                    String temp = "";
                    do {
                        popC = content.pop();
                        if ( popC == '[' )
                            break;
                        temp = popC + temp;
                    } while ( true );
                    int multiTimes = Character.getNumericValue(count.pop());
                    System.out.println(temp);
                    System.out.println(multiTimes);
                    String multiTemp = "";
                    for ( int j = 0 ; j < multiTimes ; j++ ) {
                        multiTemp += temp;
                    }
                    result += multiTemp;
                } else {
                    content.push(c);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.generateParenthesis(3));
        String test1 = "3[a]2[bc]";
        System.out.println(solution.decodeString(test1));
        String test2 = "3[a2[c]]";
        System.out.println(solution.decodeString(test2));
        String test3 = "2[abc]3[cd]ef";
        System.out.println(solution.decodeString(test3));
        String test4 = "abccdef";
        System.out.println(solution.decodeString(test4));
    }
}