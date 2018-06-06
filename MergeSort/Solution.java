class Solution {
    
    private void merge(int[] arr, int left,int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        for ( int i = 0 ; i < leftSize ; i++ )
            leftArray[i] = arr[left+i];
        for ( int j = 0 ; j < rightSize ; j++ )
            rightArray[j] = arr[mid+j+1];
        int i = 0 , j = 0, index = left;
        while( i < leftSize && j < rightSize ) {
            if ( leftArray[i] <= rightArray[j] ) {
                arr[index] = leftArray[i];
                i++;
            } else {
                arr[index] = rightArray[j];
                j++;
            }
            index++;
        }
        while( j < rightSize ) {
            arr[index] = rightArray[j];
            j++;index++;
        }
        while( i < leftSize ) {
            arr[index] = leftArray[i];
            i++;index++;
        }
    }

    public void mergeSort(int[] arr, int left, int right) {
        if ( left < right ) {
            int mid = (left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right );
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = { 2, 5, 7, 8, 9, 3, 12, 11, 4, 1, 87 };
        solution.mergeSort(test1, 0, test1.length - 1);
        for (int i = 0; i < test1.length; i++) {
            System.out.print(test1[i]+",");
        }
        System.out.println();
        int[] test2 = { 1,2,3,4,5 };
        solution.mergeSort(test2, 0, test2.length - 1);
        for (int i = 0; i < test2.length; i++) {
            System.out.print(test2[i]+",");
        }
        System.out.println();
        int[] test3 = { 5,4,3,2,1 };
        solution.mergeSort(test3, 0, test3.length - 1);
        for (int i = 0; i < test3.length; i++) {
            System.out.print(test3[i]+",");
        }
        System.out.println();
        int[] test4 = { 1,1,1,1 };
        solution.mergeSort(test4, 0, test4.length - 1);
        for (int i = 0; i < test4.length; i++) {
            System.out.print(test4[i]+",");
        }
    }
}