package mysource.two_sum;

import java.nio.file.FileStore;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for ( int first = 0; first < nums.length ; first++ ) {
            for ( int sec = 0; sec < nums.length ; sec++ ) {
                if (first != sec && nums[first] + nums[sec] == target){
                    result[0] = first;
                    result[1] = sec;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        //HashMap put the same key will replace by the latest one
        for (int index = 0 ; index < nums.length; index++ ) {
            List<Integer> content = hashMap.get(nums[index]);
            if (content == null) {
                List<Integer> saveContent = new ArrayList<>();
                saveContent.add(index);
                hashMap.put(nums[index], saveContent);
                continue;
            }
            content.add(index);
        }
        hashMap.forEach((key,value) -> {
            int temp = target - key;
            List<Integer> content = hashMap.get(temp);
            if (content != null) {
                result[0] = value.get(0);
                if (content.size() > 1) {
                    result[1] = content.get(1);
                } else {
                    result[1] = hashMap.get(temp).get(0);
                }
                
            }
        });
        return result;
    }
    public int[] twoSumFaster(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for (int index = 0 ; index < nums.length; index++ ) {
            if (hashMap.containsKey(nums[index])) {
                result[0] = hashMap.get(nums[index]);
                result[1] = index;
                break;
            } else {
                hashMap.put(target-nums[index], index);
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        twoSum solution = new twoSum();
        int[] nums = {2,7,11,15};
        int target = 18;
        int[] duplicateInput = {3,2,4};
        int target2 = 6;
        int[] duplicateInput2 = {3,3};
        int target3 = 6;
        int[] returnAns = solution.twoSum2(nums, target);
        for (int index = 0 ; index < returnAns.length ; index++ ) {
            System.out.println(returnAns[index]);
        }
        
    }
}
