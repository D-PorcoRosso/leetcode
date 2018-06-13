import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> counts = new HashMap<>();
        for ( String word : words ) {
            if ( counts.containsKey(word)) {
                int count = counts.get(word);
                count++;
                counts.put(word, count);
            } else {
                counts.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(counts.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list) {
            if ( k == 0 )
                break;
            result.add(entry.getKey());
            k--;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] test = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(solution.topKFrequent(test,4));
    }
}