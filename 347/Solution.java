import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    private class Elements {
        final int val;
        final int count;
        final int k;
        Elements(int val, int count, int k) {
            this.val = val;
            this.count = count;
            this.k = k;
        }
        boolean isLarger() {
            if ( this.k <= this.count )
                return true;
            return false;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        final List<Integer> result = new ArrayList<>();
        System.out.print(nums.length);
        int[] counts = new int[nums.length];
        for ( int num : nums) {
            counts[num-1]++;
        }
        for ( int index =0 ; index < counts.length ; index++ ) {
            if ( counts[index] != 0) {
                Elements element = new Elements(index, counts[index], k);
                if (element.isLarger())
                    result.add(index+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = { 1,1,1,2,2,3 };

        System.out.println(solution.topKFrequent(test,2));
        int[] test1 = { 1};

        System.out.println(solution.topKFrequent(test1,1));
    }
}