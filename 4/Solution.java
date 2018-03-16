class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalCount = nums1.length + nums2.length;
        int i = 0, j = 0, k = 0 ;
        do {
            if ( j < nums1.length && k < nums2.length ) {
                if ( nums1[j] < nums2[k] )
                    j++;
                else if ( nums1[j] > nums2[k] )
                    k++;
            } else {
                if ( j == nums1.length )
                    k++;
                if ( k == nums2.length )
                    j++;
            }
            i++;
        } while( i < totalCount/2 );
        if ( j == nums1.length ){
            if ( k == 0 ) {
                if ( totalCount%2 == 0 )
                    return (nums1[j-1]+nums2[k])/2.0;
                else
                    return nums1[j-1];
            } else {
                if ( totalCount%2 == 0 )
                    return (nums2[k-1]+nums2[k])/2.0;
                else
                    return nums2[k-1];
            }
        } else if ( k == nums2.length ){
            if ( j == 0 ) {
                if ( totalCount%2 == 0 )
                    return (nums1[j]+nums2[k-1])/2.0;
                else
                    return nums2[k-1];
            } else {
                if ( totalCount%2 == 0 )
                    return (nums1[j-1]+nums1[j])/2.0;
                else
                    return nums1[j-1];
            }
        } else
            return (nums1[j]+nums2[k])/2.0;
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