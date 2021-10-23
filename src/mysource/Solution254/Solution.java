package mysource.Solution254;

public class Solution {
    public List<List<Integer>> getFactors_2021_250(int n) {
        List<List<Integer>> results = new ArrayList<>();
        getFactor(n, 2, new ArrayList<>(), results);
        return results;
    }
    
    private void getFactor(int n, int start, List<Integer> result, List<List<Integer>> results) {
        if (n <= 1) {
            if (result.size() > 1)
                results.add(new ArrayList<>(result));
            return;
        }
        for ( int i = start ; i <= n ; i++ ) {
            if (n % i == 0) {
                result.add(i);
                getFactor(n/i, i, result, results);
                result.remove(result.size()-1);
            }
        }
    }
}
