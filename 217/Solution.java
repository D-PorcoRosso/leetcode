import java.util.Arrays;

class Solution {

    private int partition(int arr[], int low, int high) throws Exception {
        int pivot = arr[high];
        int i = low-1;
        for ( int j=low ; j<high ; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else if (arr[j] == pivot)
                throw new Exception("equals");
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public void quick_sort(int arr[], int left, int right) throws Exception{
        if ( left < right ) {
            int pi = partition(arr, left, right);
            quick_sort(arr, left, pi-1);
            quick_sort(arr, pi+1, right);
        }
    }

    public boolean containsDuplicate(int[] nums) {
        try {
            quick_sort(nums, 0, nums.length -1);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1,2,2,4,5};
        System.out.println(solution.containsDuplicate(test));

    }
}