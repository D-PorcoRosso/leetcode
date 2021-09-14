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

    public int[] topKFrequent_2021(int[] nums, int k) {
        HashMap<Integer, Integer> mapping = new HashMap<>();
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( mapping.get(nums[i]) == null ) {
                mapping.put(nums[i],1);
            } else {
                int count = mapping.get(nums[i]);
                mapping.put(nums[i],++count);
            }
        }
        
        int[] returnElems = new int[k];
        while( k > 0 ) {
            int max = -1, index = 0;
            for ( Map.Entry<Integer, Integer> entry : mapping.entrySet() ) {
                if (entry.getValue() >= max) {
                    max = entry.getValue();
                    index = entry.getKey();
                    returnElems[k-1] = index;
                }
            }
            mapping.put(index, 0);
            k--;
        }
        return returnElems;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = { 1,1,1,2,2,3 };

        System.out.println(solution.topKFrequent(test,2));
        int[] test1 = { 1};

        System.out.println(solution.topKFrequent(test1,1));
    }
}