class Solution {

    private int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public void quick_sort(int arr[], int left, int right) {
        if (left < right) {
            int pi = partition(arr, left, right);
            quick_sort(arr, left, pi - 1);
            quick_sort(arr, pi + 1, right);
        }
    }

    public int arrayPairSum(int[] nums) {
        quick_sort(nums, 0, nums.length -1);
        int sum = 0;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if (i%2 == 0)
                sum+=nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = { 1, 4, 3, 2 };
        System.out.println(solution.arrayPairSum(test1));
    }
}