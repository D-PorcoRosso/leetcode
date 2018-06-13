package mysource.Solution347;

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        final List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        for ( int num : nums) {
            Integer count = counts.get(num);
            if ( count == null ) {
                counts.put(num,1);
            } else {
                count++;
                counts.put(num,count);
            }
        }
        List<Map.Entry<Integer, Integer>> list_Data =
            new ArrayList<Map.Entry<Integer, Integer>>(counts.entrySet());

        Collections.sort(list_Data, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> entry1,
                               Map.Entry<Integer, Integer> entry2){
                return (entry2.getValue().compareTo(entry1.getValue()));
            }
        });


        for (Map.Entry<Integer, Integer> entry : list_Data) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if ( k == 0 )
                break;
            else {
                k--;
                result.add(key);
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