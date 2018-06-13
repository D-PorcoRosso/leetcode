import java.util.*;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for ( int i = 0 ; i < n ; i++ ) nums[i] = i+1;
        List<List<Integer>> totalResult = new LinkedList<>();
        findEachLayer(totalResult, nums, k);
        return totalResult;
    }

    private void findEachLayer(List<List<Integer>> totalResult, int[] nums, int k) {
        int n = nums.length;
        if ( k < n && k <= 0 )
            return;
        System.out.println(n+":"+k+":"+totalResult);
        if ( totalResult.size() == 0 ){
            for ( int i = 0 ; i < n ; i++ ) {
                List<Integer> currentLayer = new LinkedList<>();
                currentLayer.add(nums[i]);
                totalResult.add(currentLayer);
                int[] tempNums = new int[n-i-1];
                for( int j = i+1 ; j < n ; j++ ) tempNums[j-i-1] = nums[j];
                findEachLayer(totalResult, tempNums , k-1);
            }
        } else {
            List<List<Integer>> tempCopy = new LinkedList<>(totalResult);
            totalResult.clear();
            for ( List<Integer> currentLayer : tempCopy ) {
                for ( int i = 0 ; i < n ; i++ ) {
                    List<Integer> temp = new LinkedList<>(currentLayer);
                    temp.add(nums[i]);
                    totalResult.add(temp);
                    int[] tempNums = new int[n-i-1];
                    for( int j = i+1 ; j < n ; j++ ) tempNums[j-i-1] = nums[j];
                    findEachLayer(totalResult, tempNums , k-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println(solution.combine(4,3));
    }
}