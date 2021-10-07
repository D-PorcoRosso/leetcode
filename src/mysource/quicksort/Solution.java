package mysource.quicksort;

public class Solution {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low, j = high-1;
        if ( i == j ) {
            if (arr[low] <= arr[high]) {
                return low;
            } else {
                swap(arr, low, high);
                return high;
            }
        }
        while( i < j ) {
            while( j > low && arr[j] >= pivot ) j--;
            while( arr[i] < pivot ) i++;
            if ( i == high || j == low )
                break;
            swap(arr, i, j);
            i++;j--;
        }
        swap(arr, i, high);
        return i;
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
            System.out.print(test1[i]+",");
        }
        System.out.println();
        int[] test2 = { 1,2,3,4,5 };
        solution.quick_sort(test2, 0, test2.length - 1);
        for (int i = 0; i < test2.length; i++) {
            System.out.print(test2[i]+",");
        }
        System.out.println();
        int[] test3 = { 5,4,3,2,1 };
        solution.quick_sort(test3, 0, test3.length - 1);
        for (int i = 0; i < test3.length; i++) {
            System.out.print(test3[i]+",");
        }
        System.out.println();
        int[] test4 = { 1,1,1,1 };
        solution.quick_sort(test4, 0, test4.length - 1);
        for (int i = 0; i < test4.length; i++) {
            System.out.print(test4[i]+",");
        }
    }
}