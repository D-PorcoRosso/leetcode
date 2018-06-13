import java.util.*;
class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row1 = new LinkedList<>();
        row1.add(1);
        List<Integer> row2 = new LinkedList<>();
        row2.add(1);
        row2.add(1);

        List<Integer> cache = null;;
        for ( int i = 0 ; i <= rowIndex ; i++ ) {
            if ( i == 0 ) {
                cache = row1;
            } else if ( i == 1 ) {
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
                cache = temp;
            }
        }
        return cache;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(6));
        
    }
}