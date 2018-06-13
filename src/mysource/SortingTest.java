package mysource;

import mysource.quicksort.Solution;
import mysource.utils.RandomTest;

public class SortingTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = RandomTest.genRandomIntArray(10);
        solution.quick_sort(test1, 0, test1.length - 1);
        for ( int t : test1 )
            System.out.print(t+",");
    }
}
