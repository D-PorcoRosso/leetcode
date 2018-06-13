package mysource.Solution78;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
class Solution {
    /**
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;
        addSubset(result,new ArrayList<Integer>(),0,nums);
        return result;
    }
    
    void addSubset(List<List<Integer>> result,List<Integer> list,int start,int[] nums){
        result.add(new ArrayList<Integer>(list));
        for(int i = start;i < nums.length;i++){
            list.add(nums[i]);
            addSubset(result,list,i+1,nums);
            list.remove(list.size() - 1);
        }
    }
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();
        if ( nums.length == 0 )
            return result;
        Arrays.sort(nums);
        int index = 0, length = nums.length;
        for( int i = 0 ; i < length ; i++ ) {
            List<Integer> init = new LinkedList<>();
            init.add(nums[i]);
            result.add(init);
        }
        index++;
        for ( ; index < length ; ) {
            List<List<Integer>> resultCopy = new LinkedList<>(result);
            for( List<Integer> temp : resultCopy ) {
                int localMax = Integer.MIN_VALUE;
                for ( Integer t : temp ) if ( t > localMax ) localMax = t; 
                for( int i = 0 ; i < length ; i++ ) {
                    List<Integer> tempCopy = new LinkedList<>(temp);
                    if ( nums[i] > localMax && !tempCopy.contains(nums[i]) ) {
                        tempCopy.add(nums[i]);
                        if ( !result.contains(tempCopy) )
                            result.add(tempCopy);
                    }
                }
            }
            index++;
        }
        result.add(new LinkedList<>());
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1};
        System.out.println(solution.subsets(test));
    }
}