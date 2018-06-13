package mysource.Solution547;

import java.util.ArrayList;

public class Solution {
    public int findCircleNum(int[][]M) {
        int n = M[0].length;
        int[] group = new int[n];
        int groupCount = 1, preIndex = 0 , index = 0;
        ArrayList<Integer> nextIndex = new ArrayList<>();
        group[0] = 1;
        //{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
        while ( !isFIndAll(group) ) {
            int j = 0;
            for ( ; j < n ; j++ ) {
                if ( M[index][j] == 1 ) {
                    if ( group[j] == 0 ) {
                        group[j] = groupCount;
                        if ( !nextIndex.contains(j) ) {
                            nextIndex.add(j);
                        }
                    }
                }
                if ( j == (n-1) && !nextIndex.isEmpty() ) {
                    index = nextIndex.get(0);
                    nextIndex.remove(0);
                    j = 0;
                }
            }
            //System.out.println("round:"+preIndex);
            preIndex++;
            groupCount++;
            index = preIndex;
        }

        ArrayList<Integer> resultCount = new ArrayList<>();
        for ( int i =0 ; i < group.length ; i++) {
            int temp = group[i];
            if ( !resultCount.contains(temp) )
                resultCount.add(temp);
        }
        return resultCount.size();
    }

    private boolean isFIndAll( int[] group) {
        boolean isFound = true;
        for ( int i =0 ; i < group.length ; i++) {
            //System.out.print(group[i]+",");
            if (group[i] == 0){
                isFound = false;
            }
        }
        return isFound;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test = { {1,1,0}, {1,1,1}, {0,1,1} };
        //System.out.println(solution.findCircleNum(test));

        int[][] test2 = { {1,1,0}, {1,1,0}, {0,0,1} };
        System.out.println("+++"+solution.findCircleNum(test2));

        int[][] test3 = { {1,0,0,1}, {0,1,1,0}, {0,1,1,1}, {1,0,1,1} };
        System.out.println("+++"+solution.findCircleNum(test3));

        int[][] test4 = 
        //1,2,3,4,5,6,7,8,9,0,1,2,3,4,5
        {{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},//   1   1
         {0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},//   2   2
         {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},//   3   3
         {0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},//   4   2
         {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},//   5   4
         {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},//   6   5
         {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},//   7   6
         {0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},//   8   2
         {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},//   9   2
         {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},//   0   1
         {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},//   1   7
         {0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},//   2   2
         {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},//   3   4
         {0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},//   4   2
         {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};//   5   8
        System.out.println("+++"+solution.findCircleNum(test4));
    }
}