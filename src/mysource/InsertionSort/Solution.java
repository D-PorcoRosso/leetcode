package mysource.InsertionSort;

class Solution {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void insertionSort_2021(int[] nums) {
        for ( int i = 1 ; i < nums.length ; i++ ) {
            int targetValue = nums[i];
            for ( int j = i-1 ; j >=0 ; j-- ) {
                if (targetValue < nums[j]) {
                    swap(nums, j, j+1);
                } else 
                    break;
            }
        }
    }

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
        int[] test1 = { 87 , 2, 5, 7, 8, 9, 3, 12, 11, 4, 1};
        solution.insertionSort_2021(test1);
        for (int i = 0; i < test1.length; i++) {
            System.out.println(test1[i]);
        }
    }
}