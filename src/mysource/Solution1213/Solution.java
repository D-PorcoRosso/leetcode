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
}
