import java.util.*;

class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int[] test1 = {-4, -1, 1, 2};
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int currentMin = Integer.MAX_VALUE;
        for ( int i = 0 ; i < length ; i++ ) {
            int sum = target-nums[i];
            int j = i+1, k = length-1;
            if ( i == 0 || (i > 0 && nums[i] != nums[i-1]) )
            while (j < k) {
                //System.out.println(i+":"+j+":"+k);
                //System.out.println(nums[j]+":"+nums[k]+":"+sum+":"+currentMin);
                if ( nums[j] + nums[k] == sum ) {
                    return target;
                } else if ( nums[j] + nums[k] < sum ) {
                    int temp = Math.abs(nums[j] + nums[k] + nums[i] - target);
                    if ( currentMin > temp ) {
                        result.clear();
                        result.add(Arrays.asList(i, j, k));
                        currentMin = temp;
                    }
                    while ( j < k && nums[j] == nums[j+1] ) j++;
                    j++;
                } else {
                    int temp = Math.abs(nums[j] + nums[k] + nums[i] - target);
                    if ( currentMin > temp ) {
                        result.clear();
                        result.add(Arrays.asList(i, j, k));
                        currentMin = temp;
                    }
                    while ( j < k && nums[k] == nums[k-1] ) k--;
                    k--;
                }
            } 
        }
        List<Integer> output = result.get(0);
        int outputResult = 0;
        for ( int i : output ) {
            outputResult += nums[i];
        }
        return outputResult;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {-1, 2, 1, -4};
        //System.out.println(solution.threeSum(test1));
        //int[] test2 = {-1, 1, 8, -1, -4};
        int[] test3 = {0,0,0};
        int[] test4 = {-1,0,1,1,55};
        //int[] test4 = {82597,-9243,62390,83030,-97960,-26521,-61011,83390,-38677,12333,75987,46091,83794,19355,-71037,-6242,-288};
        System.out.println(solution.threeSumClosest(test1,2));
    }
}