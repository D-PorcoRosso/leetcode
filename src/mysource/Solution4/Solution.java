class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
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