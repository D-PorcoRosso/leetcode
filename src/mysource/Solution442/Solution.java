package mysource.Solution442;

public class Solution {
    public List<Integer> findDuplicates_2021_google_cyclesort(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        while (index < nums.length) {
            int currentIndex = nums[index]-1;
            if (nums[index] != nums[currentIndex]) {
                int temp = nums[currentIndex];
                nums[currentIndex] = nums[index];
                nums[index] = temp;
            } else {
                index++;
            }
        }
        
        for(int i = 0 ; i < nums.length ; i++) {
            if (nums[i] != i+1)
                result.add(nums[i]);
        }
        return result;
    }
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
