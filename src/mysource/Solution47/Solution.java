package mysource.Solution47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

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