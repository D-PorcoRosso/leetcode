package mysource.Solution40;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        List<List<Integer>> tempResults = new ArrayList<>();
        findCombination(candidates, target, 0, results, new ArrayList<>(), tempResults);
        return results;
    }
    
    private void findCombination(int[] candidates, int target, int start, List<List<Integer>> results, List<Integer> result, List<List<Integer>> tempResults) {
        if ( target == 0 ) {
            if (!results.contains(result))
                results.add(new ArrayList<>(result));
            return;
        }
        
        if ( target < 0 ) {
            return;
        }
        
        if (tempResults.contains(result))
            return;
        
        for ( int i = start ; i < candidates.length ; i++ ) {
            result.add(candidates[i]);
            findCombination(candidates, target - candidates[i], i+1, results, result, tempResults);
            tempResults.add(new ArrayList<>(result));
            result.remove(result.size()-1);
        }
    }
}
