package mysource.Solution47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> permuteUnique_2021_250(int[] nums) {
        int count = 1, length = nums.length;
        while(length > 0) {
            count *= length;
            length--;
        }
        List<List<Integer>> results = new ArrayList<>();
        while (count > 0) {
            List<Integer> result = arrayToList(nums);
            if(!results.contains(result)) {
                results.add(result);
            }
            nextPermutation(nums);
            count--;
        }
        return results;
    }
    
    private List<Integer> arrayToList(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for ( int num : nums) {
            result.add(num);
        }
        return result;
    }
    
    private void nextPermutation(int[] nums) {
        boolean doPermutation = false;
        for (int i = nums.length -2 ; i >=0 ;i--) {
            if (nums[i] < nums[i+1]) {
                doPermutation = true;
                int min = Integer.MAX_VALUE;
                int swapIndex = i+1;
                for ( int j = i+1 ; j < nums.length ; j++) {
                    if (nums[i] < nums[j] && min >= nums[j]) {
                        min = nums[j];
                        swapIndex = j;
                    }
                }
                swap(nums, i, swapIndex);
                int start = i+1, end = nums.length -1 ;
                while (start < end) {
                    swap(nums, start, end);
                    start++;
                    end--;
                }
                break;
            }
        }
        if (!doPermutation) {
            int start = 0, end = nums.length -1 ;
            while (start < end) {
                swap(nums, start, end);
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

    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        for ( int i = 0 ; i < length ;i++ ) {
            List<Integer> init = new ArrayList<>();
            init.add(i);
            result.add(init);
        }
        for( int times = 1 ; times < length ; times++ ) {
            List<List<Integer>> temp = new ArrayList(result);
            result.clear();
            for ( List<Integer> t : temp ) {
                List<Integer> cp = new ArrayList(t);
                for ( int i = 0 ; i < length ; i++ ) {
                    if ( !cp.contains(i) )
                        cp.add(i);
                    if(!result.contains(cp))
                        result.add(cp);
                }
            }
        }
        System.out.println(result);
        
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1,1,2};
        solution.permuteUnique(test);
        
    }
}