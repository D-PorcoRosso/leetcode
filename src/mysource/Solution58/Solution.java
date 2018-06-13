
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean prepareClear = false;
        for( int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            switch (c) {
                case ' ':
                    prepareClear = true;
                    break;
            
                default:
                    if ( prepareClear ) {
                        length = 0;
                        prepareClear = false;
                    }
                    length++;
                    break;
            }
        }
        return length;
    }

    public int lengthOfLastWord2(String s) {
        int length = 0;
        String[] splitResult = s.split(" ");
        if ( splitResult.length == 0 )
            return length;
        String last = splitResult[splitResult.length-1];
        return last.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord("World "));
        System.out.println(solution.lengthOfLastWord("b   a    "));
        System.out.println(solution.lengthOfLastWord(" "));
        System.out.println(solution.lengthOfLastWord2("Hello World"));
        System.out.println(solution.lengthOfLastWord2("World "));
        System.out.println(solution.lengthOfLastWord2("b   a    "));
        System.out.println(solution.lengthOfLastWord2(" "));
    }
}