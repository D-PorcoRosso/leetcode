import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        String result = "";
        result += parseString(result,s);
        return result;
    }

    private String parseString( String outputString, String target ) {
        int count = 0;
        int lpCount = 0;
        String returnResult = "";
        for(int i = 0;i< target.length();i++){
            char c = target.charAt(i);
            System.out.println(c);
            if ( lpCount != 0 && Character.isDigit(c) ) {
                count = Character.getNumericValue(c);
            } else {
                if (c == ']') {
                    lpCount--;
                    if (lpCount == 0) {
                        String temp = parseString(outputString, returnResult);
                        for ( int index = 0 ; index < count ; index++ ) {
                            returnResult += temp;
                        }
                    }
                } else if (c== '['){
                    lpCount++;
                } else {
                    returnResult += c;
                }
            }
        }
        outputString += returnResult;
        return outputString;
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