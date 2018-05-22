import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int pre = Integer.MIN_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        for ( int i = 0 ; i < length ; i++ ) {
            if ( pre == nums[i] ) {
                continue;
            }
            pre = nums[i];
            for ( int j = i+1 ; j < length ; j++ ) {
                for ( int k = j+1 ; k < length ; k++ ) {
                    //if ( k != j && k != i && i != j ) {
                        //System.out.println(nums[i]&nums[j]&nums[k]);
                    if ( (nums[i] + nums[j] ) == -nums[k] ) {
                        //System.out.println(nums[i]+":"+nums[j]+":"+nums[k]);
                        
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        if ( !result.contains(temp) ) {
                            result.add(temp);
                        }
                        break;
                    }
                    //}
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {-1, 0, 1, 2, -1, -4};
        //System.out.println(solution.threeSum(test1));
        //int[] test2 = {-1, 1, 8, -1, -4};
        int[] test3 = {-6,-8,-9,4,-14,6,-10,7,12,13,4,9,7,14,-12,7,0,14,-1,-3,2,2,-3,11,-6,-10,-13,-13,1,-9,2,2,-2,8,-9,0,-9,-12,14,10,8,3,4,0,-6,7,14,9,6,-2,13,-15,8,-5,3,-13,-8,5,-11,0,11,6,-13,-14,-9,-15,-7,-11,10,-7,14,4,3,3,11,13,-13,11,-1,0,-6,-10,0,9,0,10,11,0,0,-14,-15,-12,-1,10,12,-2,2,-10,2,-2,-10,2,-13,1,12,5,-1,-15,1,5,-8,3,10,8};
        int[] test4 = {82597,-9243,62390,83030,-97960,-26521,-61011,83390,-38677,12333,75987,46091,83794,19355,-71037,-6242,-288};
        List<List<Integer>> t = solution.threeSum(test3);
        System.out.println(t.size());
        System.out.println(t);
    }
}