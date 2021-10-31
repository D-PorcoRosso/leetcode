package mysource.Solution288;

public class Solution {
    private HashMap<String, List<String>> mapping = new HashMap<>();
    
    public ValidWordAbbr_2021_250(String[] dictionary) {
        for ( String word : dictionary ) {
            if (word.length() < 3) {
                if (!mapping.containsKey(word)) {
                    List<String> container = new ArrayList<>();
                    container.add(word);
                    mapping.put(word, container);
                }
            } else {
                String target = getAbbr(word);
                if (mapping.containsKey(target)) {
                    mapping.get(target).add(word);
                } else {
                    List<String> container = new ArrayList<>();
                    container.add(word);
                    mapping.put(target,container);
                }
            }
        }
}
