package mysource.Solution228;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }
        
        int start = nums[0], end = start;
        for (int i = 1 ; i < nums.length ; i++ ) {
            if (end+1 == nums[i]) {
                end = nums[i];
            } else {
                if (start == end) {
                    result.add(Integer.toString(start));
                } else {
                    result.add(start+"->"+end);
                }
                start = end = nums[i];
            }
        }
        if (start == end) {
            result.add(Integer.toString(start));
        } else {
            result.add(start+"->"+end);
        }
        return result;
    }
}
