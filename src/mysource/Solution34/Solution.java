package mysource.Solution34;

class Solution {

    public int[] searchRange_2021_250_allbinarysearch(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int firstResult = binarySearch(nums, target, 0, nums.length-1);
        if ( firstResult == -1 ) {
            result[0] = -1;
            result[1] = -1;
            return result;
        } else {
            int start = 0, end = firstResult - 1, startIndex = -2, endIndex = -2, rangeStart = -1, rangeEnd = -1;
            while (startIndex != -1 && start >=0 && end>=0) {
                startIndex = binarySearch(nums, target, start, end);
                if (startIndex != -1)
                    rangeStart = startIndex;
                end = startIndex - 1;
            }
            start = firstResult + 1;
            end = nums.length-1;
            while (endIndex != -1 && start < nums.length && end < nums.length) {
                endIndex = binarySearch(nums, target, start, end);
                if (endIndex != -1)
                    rangeEnd = endIndex;
                start = endIndex + 1;
            }
            if (rangeStart < 0)
                rangeStart = firstResult;
            if (rangeEnd < 0)
                rangeEnd = firstResult;
            result[0] = rangeStart;
            result[1] = rangeEnd;
            return result;
        }
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
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int[] result = {-1,-1};

        while ( start <= end ) {
            int mid = (start+end)/2;

            if ( target == nums[mid]) {
                //System.out.println(mid);
                int i = mid-1;
                while(i >= 0 && nums[i] == target) i--;
                result[0] = i+1;
                i = mid+1;
                while(i < nums.length && nums[i] == target) i++;
                result[1] = i-1;
                break;
            }

            if ( target < nums[mid] && nums[start] <= nums[mid] )
                end = mid - 1;

            if ( target > nums[mid] && nums[mid] <= nums[end] )
                start = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {5,7,7,8,8,10};
        int[] r = solution.searchRange(test1,4);
        System.out.println(r[0] +":"+ r[1]);
        r = solution.searchRange(test1,8);
        System.out.println(r[0] +":"+ r[1]);
        int[] test2 = {8,8,8,8,8,8,8};
        r = solution.searchRange(test2,3);
        System.out.println(r[0] +":"+ r[1]);
        r = solution.searchRange(test2,8);
        System.out.println(r[0] +":"+ r[1]);

            

    }
}