package mysource.Solution90;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
class Solution {
    /*
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        helper(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> cur, int[] nums, int index) {
        if (nums.length == index) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        cur.add(nums[index]);
        helper(result, cur, nums, index + 1);
        cur.remove(cur.size() - 1);
        while (index + 1 < nums.length && nums[index + 1] == nums[index]) {
            index++;
        }
        helper(result, cur, nums, index + 1);
    } */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> next = new LinkedList<>();
        List<List<Integer>> indexResult = new LinkedList<>();
        for ( int i = 0 ; i < length ; i++ ) {
            List<Integer> init = new LinkedList<>();
            init.add(i);
            next.add(init);
        }
        indexResult.addAll(next);
        int layer = 0;
        while(layer<length-1) {
            List<List<Integer>> nextCopy = new LinkedList<>(next);
            next.clear();
            for ( List<Integer> l : nextCopy ) {
                for ( int j = 0 ; j < length ; j++ ) {
                    if ( l.get(layer) < j ) {
                        List<Integer> lCopy = new LinkedList<>(l);
                        lCopy.add(j);
                        next.add(lCopy);
                    }
                }
            }
            indexResult.addAll(next);
            layer++;
        }
        
        List<List<Integer>> result = new LinkedList<>();
        for ( List<Integer> index : indexResult ) {
            List<Integer> realValue = new LinkedList<>();
            for( Integer i : index ) {
                realValue.add(nums[i]);
            }
            //Collections.sort(realValue);
            if ( !result.contains(realValue) )
                result.add(realValue);
        }
        result.add(new LinkedList<>());
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t1 = {1,2,2};
        //System.out.println(solution.subsetsWithDup(t1));
        int[] t2 = {4,4,4,1,4};
        System.out.println(solution.subsetsWithDup(t2));
    }
}