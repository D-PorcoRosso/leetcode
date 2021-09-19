package mysource.Solution4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int target = total/2;

        int[] mergedArray = new int[nums1.length+nums2.length];
        int i = 0, j = 0; 
        int boundary = 0;
        while ( boundary < target +1 && boundary < nums1.length+nums2.length) {
            if (i == nums1.length && nums2.length != 0) {
                mergedArray[boundary]=nums2[j];
                j++;
            } else if (j == nums2.length && nums1.length != 0) {
                mergedArray[boundary]=nums1[i];
                i++;
            }
            if (i < nums1.length && j < nums2.length ) {
                if (nums1[i] > nums2[j]) {
                    mergedArray[boundary]=nums2[j];
                    j++;
                } else {
                    mergedArray[boundary]=nums1[i];
                    i++;
                }
            }
            boundary++;
        }
        if ( total % 2 == 0 ) {
            return (mergedArray[target] + mergedArray[target-1])/2.0;
        } else {
            return mergedArray[target];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
        int[] nums3 = {1,2};
        int[] nums4 = {3,4,5,6,7,8};
        System.out.println(solution.findMedianSortedArrays(nums3, nums4));
        int[] nums5 = {1,3};
        int[] nums6 = {2};
        System.out.println(solution.findMedianSortedArrays(nums5, nums6));
    }
}