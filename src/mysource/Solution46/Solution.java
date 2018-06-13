package mysource.Solution46;

import java.util.ArrayList;
import java.util.List;


class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<List<Integer>> oldResults = new ArrayList<>();
        for ( int num : nums ) {
            List<Integer> inner = new ArrayList<>();
            inner.add(num);
            oldResults.add(inner);
        }

        if ( nums.length == 0 )
            return results;
        else if ( nums.length == 1 )
            return oldResults;

        for( int i = 1 ; i < nums.length ; i++) {
            results.clear();
            for ( List<Integer> result : oldResults ) {
                List<Integer> conpair = new ArrayList<>(result);
                for ( int num : nums ) {
                    if ( !conpair.contains(num) ) {
                        List<Integer> temp = new ArrayList<>();
                        temp.addAll(result);
                        temp.add(num);
                        results.add(temp);
                    }
                }
            }
            oldResults.clear();
            for ( List<Integer> result : results ) {
                List<Integer> temp = new ArrayList<>();
                for ( int num : result ) {
                    temp.add(num);
                }
                oldResults.add(temp);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1};
        System.out.println(solution.permute(test));
    }
}