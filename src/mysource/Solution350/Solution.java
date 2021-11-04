package mysource.Solution350;

public class Solution {
    public int[] intersect_2021_amz(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length) {
            return findIntersection(nums2, nums1);
        } else {
            return findIntersection(nums1, nums2);
        }
    }
    
    private int[] findIntersection(int[] largeNums, int[] smallNums) {
        List<Integer> intersection = new ArrayList<>();
        Set<Integer> index = new HashSet<>();
        for (int i = 0 ; i < smallNums.length ; i++ ) {
            for (int j = 0 ; j < largeNums.length ; j++ ) {
                if (smallNums[i] == largeNums[j] && index.add(j)) {
                    intersection.add(smallNums[i]);
                    break;
                }
            }
        }
        int[] result = new int[intersection.size()];
        for ( int i = 0 ; i < intersection.size() ; i++ ) 
            result[i] = intersection.get(i);
        return result;
    }
}
