
class Solution {
    public String countAndSay(int n) {
        int current = 1;
        int outCount = 0;
        String currentResult = "1",nextRound = "1";
        for ( int i = 1 ; i <= n ; i++ ) {
            //System.out.println(currentResult);
            char currentChar = currentResult.charAt(0);
            currentResult = nextRound;
            nextRound = "";
            for ( int j = 0 ; j < currentResult.length() ; ) {
                if ( currentChar == currentResult.charAt(j)) {
                    outCount++;
                    j++;
                } else {
                    nextRound += String.valueOf(outCount);
                    nextRound += String.valueOf(currentChar);
                    outCount = 0;
                    currentChar = currentResult.charAt(j);
                }
            }
            if ( nextRound.equals("") ) {
                nextRound += String.valueOf(outCount);
                nextRound += String.valueOf(currentChar);
            }
            currentResult = nextRound;
        }
        return nextRound;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    
        System.out.println(solution.countAndSay(4));
    }
}