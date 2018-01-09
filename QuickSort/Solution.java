class Solution {

    private int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        for ( int j=low ; j<high ; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public void quick_sort(int arr[], int left, int right) {
        if ( left < right ) {
            int pi = partition(arr, left, right);
            quick_sort(arr, left, pi-1);
            quick_sort(arr, pi+1, right);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = { 2, 5, 7, 8, 9, 3, 12, 11, 4, 1, 87 };
        solution.quick_sort(test1, 0, test1.length - 1);
        for (int i = 0; i < test1.length; i++) {
            System.out.println(test1[i]);
        }
    }
}