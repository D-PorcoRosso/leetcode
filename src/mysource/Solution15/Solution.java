package mysource.Solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for ( int i = 0 ; i < length ; i++ ) {
            int sum = -nums[i];
            int j = i+1, k = length-1;
            if ( i == 0 || (i > 0 && nums[i] != nums[i-1]) )
            while (j < k) {
                if ( nums[j] + nums[k] == sum ) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while ( j < k && nums[j] == nums[j+1] ) j++;
                    while ( j < k && nums[k] == nums[k-1] ) k--;
                    j++;k--;
                } else if ( nums[j] + nums[k] < sum ) {
                    j++;
                } else {
                    k--;
                }
            } 
        }
        return result;
    }

    //o(n^3) time exceed
    public List<List<Integer>> threeSum2021(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for ( int i = 0 ; i < length ; i++ ) {
            for ( int j = i+1 ; j < length ; j++ ) {
                for (int k = j+1;k < length ; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        Integer[] temp = {nums[i],nums[j],nums[k]};
                        Arrays.sort(temp);
                        List<Integer> sorted = Arrays.asList(temp);
                        if (!result.contains(sorted)) {
                            result.add(sorted);
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2021_faster(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int pivot = 0 ; pivot < nums.length && nums[pivot] <=0 ; pivot++) {
            if (pivot == 0 || nums[pivot-1] != nums[pivot]) {
                int start = pivot+1, end = nums.length - 1;
                int target = -nums[pivot];
                while(start < end) {
                    if (nums[start] + nums[end] == target) {
                        List<Integer> ans = Arrays.asList(nums[pivot], nums[start++], nums[end--]);
                        result.add(ans);
                        while (start < end && nums[start] == nums[start-1]) {
                            start++;
                        }
                    } else {
                        if (nums[start] + nums[end] < target) {
                            start++;
                        }
                        if (nums[start] + nums[end] > target) {
                            end--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum_2021_250(int[] nums) {
        if (nums.length < 2)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for ( int k = nums.length - 1 ; k >= 0 ; k-- ) {
            int target = 0 - nums[k];
            int i = 0, j = k-1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    if (!results.contains(result))
                        results.add(result);
                    i++;
                    j--;
                } else if ( nums[i] + nums[j] < target ) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {-1, 0, 1, 2, -1, -4};
        //System.out.println(solution.threeSum(test1));
        //int[] test2 = {-1, 1, 8, -1, -4};
        int[] test3 = {-6,-8,-9,4,-14,6,-10,7,12,13,4,9,7,14,-12,7,0,14,-1,-3,2,2,-3,11,-6,-10,-13,-13,1,-9,2,2,-2,8,-9,0,-9,-12,14,10,8,3,4,0,-6,7,14,9,6,-2,13,-15,8,-5,3,-13,-8,5,-11,0,11,6,-13,-14,-9,-15,-7,-11,10,-7,14,4,3,3,11,13,-13,11,-1,0,-6,-10,0,9,0,10,11,0,0,-14,-15,-12,-1,10,12,-2,2,-10,2,-2,-10,2,-13,1,12,5,-1,-15,1,5,-8,3,10,8};
        int[] test4 = {82597,-9243,62390,83030,-97960,-26521,-61011,83390,-38677,12333,75987,46091,83794,19355,-71037,-6242,-288};
        List<List<Integer>> t = solution.threeSum2021_faster(test1);
        System.out.println(t.size());
        System.out.println(t);
    }
}