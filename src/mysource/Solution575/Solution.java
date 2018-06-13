package mysource.Solution575;

import java.util.HashMap;

class Solution {
    public int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> distribute = new HashMap<>();
        for ( int i = 0 ; i < candies.length ; i++ ) {
            Integer count = distribute.get(candies[i]);
            if ( count == null ) {
                distribute.put(candies[i] , 1);
            } else {
                count++;
                distribute.put(candies[i] , count);
            }
        }
        if ( candies.length/2 > distribute.size() )
            return distribute.size();
        else {
            return candies.length/2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1,1,2,3};
        System.out.println(solution.distributeCandies(test));
        int[] test1 = {1,1,1,1,1,1,2,3};
        System.out.println(solution.distributeCandies(test1));
        int[] test2 = {1,1,2,2,3,3};
        System.out.println(solution.distributeCandies(test2));
    }
}