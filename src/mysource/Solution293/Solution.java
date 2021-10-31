package mysource.Solution293;

public class Solution {
    public List<String> generatePossibleNextMoves_2021_250(String currentState) {
        List<String> results = new ArrayList<>();
        if(currentState.length() < 2) {
            return results;
        }
        
        for ( int i = 0 ; i < currentState.length() - 1 ; i++ ) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i+1) == '+') {
                String result = currentState.substring(0,i)+"--"+currentState.substring(i+2);
                results.add(result);
            }
        }
        return results;
    }
}
