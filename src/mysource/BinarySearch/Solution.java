package mysource.BinarySearch;

class Solution {
    int binarySearch(int nums[], int l, int r, int x) {
        if ( r >= l ) {
            int mid = l + (r - l)/2;
            if (nums[mid] == x)
                return mid;
            if (nums[mid] > x)
                return binarySearch(nums, l, mid - 1 ,x);
            return binarySearch(nums, mid + 1, r, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = { 2, 5, 7, 8, 9, 12, 19, 87 };
        int where = solution.binarySearch(test1, 0, test1.length-1, 9);
        System.out.println(where);
        where = solution.binarySearch(test1, 0, test1.length-1, 13);
        System.out.println(where);
    }
}