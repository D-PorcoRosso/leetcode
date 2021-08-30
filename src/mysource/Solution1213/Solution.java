package mysource.Solution1213;

public class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        for ( int i = 0 ; i < arr1.length ; i++ ) {
            if (isExist(arr1[i], arr2) && isExist(arr1[i], arr3))
                result.add(arr1[i]);
        }
        return result;
    }
    
    private boolean isExist(int target, int[] array) {
        for ( int i = 0 ; i < array.length ; i++ ) {
            if (target == array[i])
                return true;
        }
        return false;
    }

    private boolean isExistBinarySearch(int target, int[] array) {
        int start = 0, end = array.length - 1, mid;
        
        while (start <= end) {
            mid = start + (end - start)/2;
            if (target == array[mid])
                return true;
            if (target > array[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
