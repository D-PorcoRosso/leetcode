import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> totalResult = new ArrayList<>();
        //currentRound(candidates, target, result, totalResult, 0);
        System.out.println(currentRound(candidates, target, result, totalResult, 0));
        return null;
    }

    private List<Integer> currentRound(int[] candidates, int target, List<Integer> result
        , List<List<Integer>> totalResult, int currentDepth) {
        System.out.println(result+":"+target+" depth:"+currentDepth);
        for ( int i = 0 ; i < candidates.length ; i++ ) {
            if ( candidates[i] == target ) {
                result.add(target);
                totalResult.add(result);
                return new ArrayList<>();
            } else if ( target - candidates[i] < 0 ) {
                result.remove(currentDepth-1);
                return null;
            } else {
                result.add(candidates[i]);
                currentDepth++;
                currentRound(candidates, target - candidates[i], result, totalResult, currentDepth);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {2,3,6,7};
        System.out.println(solution.combinationSum(test1, 7));
        //6 -> 2111121211
    }
}