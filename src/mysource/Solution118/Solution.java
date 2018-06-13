package mysource.Solution118;

import java.util.LinkedList;
import java.util.List;
class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> row1 = new LinkedList<>();
        row1.add(1);
        List<Integer> row2 = new LinkedList<>();
        row2.add(1);
        row2.add(1);

        List<Integer> cache = null;;
        for ( int i = 0 ; i < numRows ; i++ ) {
            if ( i == 0 )
                result.add(row1);
            else if ( i == 1 ) {
                result.add(row2);
                cache = row2;  
            } else {
                List<Integer> temp = new LinkedList<>();
                for ( int j = 0 ; j < i+1 ; j++ ) {
                    if ( j == 0 || j == i ) {
                        temp.add(1);
                    } else {
                        int n = cache.get(j-1) + cache.get(j); 
                        temp.add(n);
                    }
                }
                System.out.println(temp);
                result.add(temp);
                cache = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generate(6);
        
    }
}