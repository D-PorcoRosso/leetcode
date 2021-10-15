package mysource.Solution216;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k > n)
            return new ArrayList<>();
        
        List<List<Integer>> results = new ArrayList<>();
        boolean[] numsUsed = new boolean[10];
        findCombination(numsUsed, k, k, n, 1, new ArrayList<>(), results);
        return results;
    }
    
    private void findCombination(boolean[] numsUsed, int totalK, int k, int n, int start, List<Integer> result, List<List<Integer>> results) {
        
        if ( k == 1 ) {
            if (n <= 0  || result.size() == totalK ||
                result.contains(n) || start > n || n >= 10)
                return;
            result.add(n);
            results.add(new ArrayList<>(result));
            result.remove(result.size()-1);
            return;
        }
        
        for ( int i = start ; i < 10 ; i++ ) {
            if (!numsUsed[i]) {
                numsUsed[i] = true;
                result.add(i);
                findCombination(numsUsed, totalK, k-1, n-i, i+1, result, results);
                result.remove(result.size()-1);
                numsUsed[i] = false;
            }
        }
    }
}
