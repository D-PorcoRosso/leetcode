import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer, Integer> relation = new HashMap<>();
        for ( int i = 0 ; i < nums.length ; i++ ) {
            relation.put(i, nums[i]);
        }

        String[] result = new String[nums.length];

        int max = -1, levelCount = 3, maxIndex = -1;
        for ( int i = 0 ; i < relation.size() ; i++ ) {
            for ( Map.Entry<Integer, Integer> temp : relation.entrySet() ) {
                if ( temp.getValue() > max ) {
                    maxIndex = temp.getKey();
                    max = temp.getValue();
                }
            }
            if ( levelCount == 3 ) {
                result[maxIndex] = "Gold Medal";
            } else if ( levelCount == 2 ) {
                result[maxIndex] = "Silver Medal";
            } else if ( levelCount == 1 ) {
                result[maxIndex] = "Bronze Medal";
            } else {
                result[maxIndex] = ""+(i + 1);
            }
            levelCount--;
            relation.put(maxIndex, -1);
            max = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temp = {2,4,3,5,1};
        String[] result = solution.findRelativeRanks(temp);
        for ( String r : result ) {
            System.out.println(r);
        }

        int[] temp2 = {10,3,8,9,4};
        result = solution.findRelativeRanks(temp2);
        for ( String r : result ) {
            System.out.println(r);
        }

    }
}