package mysource.Solution219;

public class Solution {
    public boolean containsNearbyDuplicate_2021_250(int[] nums, int k) {
        HashMap<Integer, Integer> mem = new HashMap<>();
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if (mem.get(nums[i]) != null) {
                if (i - mem.get(nums[i]) <= k)
                    return true;
                else{
                    mem.put(nums[i], i);
                }
            } else {
                mem.put(nums[i], i);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> existTable = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            List<Integer> sameList = existTable.get(nums[i]);
            if (sameList == null) {
                sameList = new ArrayList<>();
                existTable.put(nums[i], sameList);
            }
            sameList.add(i);
        }
        for (Map.Entry<Integer, List<Integer>> map : existTable.entrySet() ) {
            List<Integer> sameIndex = map.getValue();
            if (sameIndex.size() > 1) {
                for (int i = 0 ; i < sameIndex.size(); i++) {
                    for (int j = i+1 ; j < sameIndex.size(); j++) {
                        if (Math.abs(sameIndex.get(i) - sameIndex.get(j)) <=k )
                            return true;
                    }
                }
            }
        }
        return false;
    }
}
