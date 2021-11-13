package mysource.Solution442;

public class Solution {
    public List<Integer> findDuplicates_2021_google(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> container = new HashSet<>();
        for (int num : nums) {
            if(!container.add(num)) {
                result.add(num);
            }
        }
        return result;
    }
}
