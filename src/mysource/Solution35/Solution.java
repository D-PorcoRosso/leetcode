package mysource.Solution35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        for ( int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == target || target < nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsert_2021_250(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    
    private int binarySearch(int[] nums, int target, int start, int end) {
        int mid = -1;
        while (start <= end) {
            mid = (end-start)/2 + start;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (nums[mid] > target) {
            return mid;
        }
        return mid+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t1 = {1,3,5,6};
        int[] t2 = {1};
        int[] t3 = {1,3};
        System.out.println(solution.searchInsert(t2, 0));
        assert (solution.searchInsert(t1, 3) == 1 ) : "error";
        System.out.println("1 true");
        assert (solution.searchInsert(t1, 8) == 4 ) : "error";
        System.out.println("2 true");
        assert (solution.searchInsert(t1, 1) == 0 ) : "error";
        System.out.println("3 true");
        assert (solution.searchInsert(t1, 6) == 3 ) : "error";
        System.out.println("4 true");
        assert (solution.searchInsert(t2, 0) == 0 ) : "error";
        System.out.println("5 true");
        assert (solution.searchInsert(t3, 2) == 1 ) : "error";
        System.out.println("6 true");
    }
}