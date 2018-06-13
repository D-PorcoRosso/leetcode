package mysource.quicksort;

public class Solution {
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low, j = high-1, temp = 0;
        if ( i == j )
            return arr[low] <= arr[high] ? high : low;
        while( i < j ) {
            while( j > low && arr[j] >= pivot ) j--;
            while( arr[i] < pivot ) i++;
            if ( i == high || j == low )
                break;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;j--;
        }
        temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public void quick_sort(int arr[], int left, int right) {
        if ( left < right ) {
            int pi = partition(arr, left, right);
            quick_sort(arr, left, pi-1);
            quick_sort(arr, pi+1, right);
        }
    }
}