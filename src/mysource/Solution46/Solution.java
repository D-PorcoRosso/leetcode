package mysource.Solution46;

import java.util.ArrayList;
import java.util.List;


class Solution {

    public List<List<Integer>> permute_2021_250(int[] nums) {
        int count = 1, length = nums.length;
        while(length > 0) {
            count *= length;
            --length;
        }
        List<List<Integer>> results = new ArrayList<>();
        
        while(count > 0) {
            List<Integer> result = arrayToList(nums);
            results.add(result);
            nextPermutation(nums);
            --count;
        }
        return results;
    }
    
    private List<Integer> arrayToList(int[] inputs) {
        List<Integer> result = new ArrayList<>();
        for ( int i : inputs) {
            result.add(i);
        }
        return result;
    }
    
    private void nextPermutation(int[] nums) {
        boolean doPermutation = false;
        for (int i = nums.length - 2 ; i >=0 ; i--) {
            if (nums[i] < nums[i+1]) {
                doPermutation = true;
                int min = Integer.MAX_VALUE;
                int swapIndex = i+1;
                for ( int j = i+1 ; j < nums.length ; j++ ) {
                    if (nums[i] < nums[j] && min > nums[j]) {
                        min = nums[j];
                        swapIndex = j;
                    }
                }
                swap(nums,i, swapIndex);
                int start = i+1, end = nums.length - 1;
                while( start < end ) {
                    swap(nums,start, end);
                    start++;
                    end--;
                }
                break;
            }
        }
        if (!doPermutation) {
            int start = 0, end = nums.length - 1;
            while( start < end ) {
                swap(nums,start, end);
                start++;
                end--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

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