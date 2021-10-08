package mysource.HeapSort;

class Solution {

    private void swap(int[]arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void heapSort_2021(int[] arr, int size) {
        int left, right, startPoint = arr.length - 1 - size;
        if (startPoint == 0)
            return;
        for (int j = startPoint; j >= 0 ; j--) {
            left = 2*j+1;
            right = 2*j+2;
            if (left > startPoint)
                continue;
            if (right > startPoint) {
                if (arr[j] < arr[left]) {
                    swap(arr, j, left);
                }
            } else {
                if (arr[left] < arr[right]) {
                    if (arr[right] > arr[j]) {
                        swap(arr, right,j);
                    }
                } else {
                    if (arr[left] > arr[j]) {
                        swap(arr, left,j);
                    }
                }
            }
        }
        swap(arr, 0, startPoint);
        heapSort_2021(arr, size+1);
    }

    public void heapSort(int[] arr, int size) {
        
        int leftNodeIndex , rightNodeIndex, temp, length = arr.length-size;
        if ( length == 1 )
            return;
        for ( int i = length/2 ; i >= 0 ; i-- ) {
            leftNodeIndex = 2 * i +1;
            rightNodeIndex = 2 * i +2;
            if ( leftNodeIndex < length )
            if ( arr[i] < arr[leftNodeIndex] ) {
                temp = arr[i];
                arr[i] = arr[leftNodeIndex];
                arr[leftNodeIndex] = temp;
            }
            if ( rightNodeIndex < length )
            if ( arr[i] < arr[rightNodeIndex] ) {
                temp = arr[i];
                arr[i] = arr[rightNodeIndex];
                arr[rightNodeIndex] = temp;
            }
            
        }
        temp = arr[0];
        arr[0] = arr[length-1];
        arr[length-1] = temp;
        for ( int i = 0 ; i < arr.length ; i++) 
        System.out.print(arr[i]+",");
        System.out.println();
        heapSort(arr, size+1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = { 2, 5, 7, 8, 9, 3, 12, 11, 4, 1, 87 };
        solution.heapSort_2021(test1,0);
        for (int i = 0; i < test1.length; i++) {
            System.out.print(test1[i]+",");
        }
        System.out.println();
        int[] test2 = { 1,2,3,4,5 };
        solution.heapSort_2021(test2,0);
        for (int i = 0; i < test2.length; i++) {
            System.out.print(test2[i]+",");
        }
        System.out.println();
        int[] test3 = { 5,4,3,2,1 };
        solution.heapSort_2021(test3,0);
        for (int i = 0; i < test3.length; i++) {
            System.out.print(test3[i]+",");
        }
        System.out.println();
        int[] test4 = { 1,1,1,1 };
        solution.heapSort_2021(test4,0);
        for (int i = 0; i < test4.length; i++) {
            System.out.print(test4[i]+",");
        }
    }
}