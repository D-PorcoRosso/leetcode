import java.util.*;
class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if ( triangle.size() == 0 ) 
            return 0;
        int[] layerMin = new int[triangle.get(triangle.size()-1).size()];

        List<Integer> temp = triangle.get(triangle.size() - 1);
        for ( int j = 0 ; j < temp.size() ; j++ ) {
            layerMin[j] = temp.get(j);
        }

        for ( int i = triangle.size() - 2 ; i >=0 ; i-- ) {
            temp = triangle.get(i);
            for ( int j = 0 ; j < temp.size() ; j++ ) {
                int num = temp.get(j);
                if ( layerMin[j] < layerMin[j+1] )
                    layerMin[j] += num;
                else
                    layerMin[j] = layerMin[j+1] + num;
            }
        }
        
        return layerMin[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> one = new ArrayList<>();
        one.add(2);
        List<Integer> two = new ArrayList<>();
        two.add(3);
        two.add(4);
        List<Integer> three = new ArrayList<>();
        three.add(6);
        three.add(5);
        three.add(7);
        List<Integer> four = new ArrayList<>();
        four.add(4);
        four.add(1);
        four.add(8);
        four.add(3);
        List<List<Integer>> input = new ArrayList<>();
        input.add(one);
        input.add(two);
        input.add(three);
        input.add(four);
        System.out.println(solution.minimumTotal(input));
        
    }
}