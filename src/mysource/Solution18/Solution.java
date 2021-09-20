package mysource.Solution18;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<List<Integer>> fourSum_2021(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        boolean findEqual = false;
        List<List<Integer>> results = new ArrayList<>();
        for ( int i = 0 ; i < length ; i++ ) {
            for ( int j = i+1 ; j < length ; j++ ) {
                for ( int k = j+1 ; k < length ; k++ ) {
                    for ( int l = k+1 ; l < length ; l++ ) {
                        if (nums[l] == nums[l-1] && findEqual) {
                            continue;
                        }
                        if (nums[i]+nums[j]+nums[k]+nums[l] == target) {
                            findEqual = true;
                            List<Integer> result = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            if (!results.contains(result)) {
                                results.add(result);
                                break;
                            }
                        }
                    }
                    findEqual = false;
                }
            }
        }
        return results;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for ( int l = 0 ; l < length ; l++ ) {
            int localTarget = target - nums[l];
            for ( int i = 0 ; i < length ; i++ ) {
                if ( i != l ) {
                int sum = localTarget - nums[i];
                int j = i+1, k = length-1;
                if ( i == 0 || (i > 0 && nums[i] != nums[i-1]) )
                while (j < k) {
                    if ( nums[j] + nums[k] == sum ) {
                        
                        result.add(Arrays.asList(nums[l],nums[i], nums[j], nums[k]));
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
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {-1, 0, 1, 2, -1, -4};
        //System.out.println(solution.threeSum(test1));
        int[] test2 = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> t = solution.fourSum(test2,0);
        System.out.println(t.size());
        System.out.println(t);
    }
}