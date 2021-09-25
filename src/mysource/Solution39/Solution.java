package mysource.Solution39;

import java.util.ArrayList;
import java.util.List;

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

    public List<List<Integer>> combinationSum_2021(int[] candidates, int target) {
        LinkedList<Integer> tempResult = new LinkedList<>();
        List<List<Integer>> results = new ArrayList<>();
        backtrack(target, tempResult, 0, candidates, results);
        return results;
    }
    
    private void backtrack(int target, LinkedList<Integer> tempResult, int start, int[] candidates, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(tempResult));
        }
        if (target < 0)
            return;
        for ( int i = start ; i < candidates.length ; i++ ) {
            tempResult.add(candidates[i]);
            backtrack(target - candidates[i], tempResult, i, candidates, results);
            tempResult.removeLast();
        }
    }

    public List<List<Integer>> combinationSum_2021_250(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
    
        findCombination(candidates, target, 0, results, new ArrayList<>());
        
        return results;
    }
    
    //start is prevent 2,3 or 3,2
    private void findCombination(int[] candidates, int target, int start, List<List<Integer>> results, List<Integer> result) {
        if (target == 0) {
            if (!results.contains(result))
                results.add(new ArrayList<>(result));
            return;
        }
        if (target < 0)
            return;
        for ( int i = start ; i < candidates.length ; i++ ) {
            result.add(candidates[i]);
            findCombination(candidates, target - candidates[i], i, results, result);
            result.remove(result.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {2,3,6,7};
        System.out.println(solution.combinationSum(test1, 7));
        //6 -> 2111121211
    }
}