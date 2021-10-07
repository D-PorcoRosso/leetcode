package mysource.SelectionSort;

public class Solution {
    public void seletctionSort(int[] arr) {
        for ( int i = 0 ; i < arr.length - 1 ; i++ ) {
            int min = arr[i], index = i;
            for ( int j = i + 1 ; j < arr.length ; j++ ) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = { 2, 5, 7, 8, 9, 3, 12, 11, 4, 1, 87 };
        solution.seletctionSort(test1);
        for (int i = 0; i < test1.length; i++) {
            System.out.print(test1[i]+",");
        }
        System.out.println();
        int[] test2 = { 1,2,3,4,5 };
        solution.seletctionSort(test2);
        for (int i = 0; i < test2.length; i++) {
            System.out.print(test2[i]+",");
        }
        System.out.println();
        int[] test3 = { 5,4,3,2,1 };
        solution.seletctionSort(test3);
        for (int i = 0; i < test3.length; i++) {
            System.out.print(test3[i]+",");
        }
        System.out.println();
        int[] test4 = { 1,1,1,1 };
        solution.seletctionSort(test4);
        for (int i = 0; i < test4.length; i++) {
            System.out.print(test4[i]+",");
        }
    }
}
