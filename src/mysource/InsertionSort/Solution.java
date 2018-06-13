package mysource.InsertionSort;

class Solution {
    public int[] insertionSort(int[] nums) {
        for (int i = 1 ; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            for (; j > 0 && temp < nums[j-1]; j--) {
                nums[j] = nums[j-1];
            }
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = { 2, 5, 7, 8, 9, 3, 12, 11, 4, 1, 87 };
        int[] result1 = solution.insertionSort(test1);
        for (int i = 0; i < result1.length; i++) {
            System.out.println(result1[i]);
        }
    }
}