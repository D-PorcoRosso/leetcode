import java.util.*;
class Solution {
    public void radixSort(int[] a) {
        int max = a[0], length = a.length;
        for ( int i = 1 ; i < length ; i++ ) if ( a[i] > max ) max = a[i];
        for ( int exp = 1 ; max/exp > 0 ; exp*=10 ) {
            countSort(a, length, exp);
        }
    }

    private void countSort(int[]a , int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for ( int i = 0 ; i < n ; i++ ) 
            count[(a[i]/exp)%10]++;
        for ( int i = 1 ; i < 10 ; i++ )
            count[i] += count[i-1];
        for ( int i = n-1 ; i >=0; i-- ) {
            int position = (a[i]/exp)%10;
            count[position]--;
            output[count[position]] = a[i];
        }
        for ( int i = 0 ; i < n ; i++ ) {
            a[i] = output[i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = { 2, 5, 7, 8, 9, 3, 12, 11, 4, 1, 87 };
        solution.radixSort(test1);
        for (int i = 0; i < test1.length; i++) {
            System.out.print(test1[i]+",");
        }
        System.out.println();
        int[] test2 = { 1,2,3,4,5 };
        solution.radixSort(test2);
        for (int i = 0; i < test2.length; i++) {
            System.out.print(test2[i]+",");
        }
        System.out.println();
        int[] test3 = { 5,4,3,2,1 };
        solution.radixSort(test3);
        for (int i = 0; i < test3.length; i++) {
            System.out.print(test3[i]+",");
        }
        System.out.println();
        int[] test4 = { 1,1,1,1 };
        solution.radixSort(test4);
        for (int i = 0; i < test4.length; i++) {
            System.out.print(test4[i]+",");
        }
    }
}