package mysource.Solution115;

public class Solution {
    public int numDistinct_2021_250(String s, String t) {
        List<String> results = new ArrayList<>();
        boolean[] dpTable = new boolean[s.length()+1];
        permutitationByIndex(s, 0, results, "", t, dpTable);
        return results.size();
    }
    
    private void permutitationByIndex(String s, int start, List<String> results, String tempResult, String target, boolean[] dpTable) {
        
        for ( int i = start ; i < s.length() ; i++ ) {
            tempResult = tempResult + s.charAt(i);
            System.out.println("start:"+start+" i:"+i+" temp:"+tempResult);
            if (tempResult.equals(target)) {
                results.add(tempResult);
                //dpTable[i] = true;
            }
            permutitationByIndex(s, i+1, results, tempResult, target, dpTable);
            tempResult = tempResult.substring(0, tempResult.length()-1);

        }
    }
}
