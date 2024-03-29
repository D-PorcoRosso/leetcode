package mysource.Solution128;

public class Solution {
    public int longestConsecutive_2021_250(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i] == nums[i-1] + 1) {
                count++;
                if (count > max)
                    max = count;
            } else if (nums[i] == nums[i-1]) {
                
            } else {
                count = 1;
            }
        }
        if (max == Integer.MIN_VALUE) {
            return nums.length >= 1 ? 1 : 0;
        }
        return max;
    }

    public int longestConsecutive_2021(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int maxCount = -1, count = 1;
        for ( int i = 1 ; i < nums.length ; i++ ) {
            if (nums[i] == nums[i-1])
                continue;
            if ( nums[i] == nums[i-1]+1 ) {
                count++;
                if (maxCount < count)
                    maxCount = count;
            } else {
                count = 1;
            }
        }
        if (maxCount == -1)
            return count;
        return maxCount;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashMap<Integer, List<Integer>> mapping = new HashMap<>();
        for ( int i = 0 ; i < nums.length ; i++ ) {
            int div = nums[i]/(nums.length+1);
            List<Integer> temp = mapping.get(div);
            if ( temp == null) {
                temp = new ArrayList<>();
                mapping.put(div, temp);
            }
            temp.add(nums[i]);
        }
        int max = -1, index = 0;
        for ( Map.Entry<Integer, List<Integer>> entry : mapping.entrySet() ) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                index = entry.getKey();
            }
        }
        List<Integer> target = mapping.get(index);
        int localMin = Integer.MAX_VALUE, localMax = Integer.MIN_VALUE;
        for (int i = 0 ; i < target.size() ;i++ ) {
            if (target.get(i) < localMin)
                localMin = target.get(i);
            if (target.get(i) > localMax)
                localMax = target.get(i);
        }
        int maxCount = -1, count = 0;
        for ( int i = localMin ; i <= localMax ; i++ ) {
            if ( target.contains(i) ) {
                count++;
                if (maxCount < count) 
                    maxCount = count;
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
}
