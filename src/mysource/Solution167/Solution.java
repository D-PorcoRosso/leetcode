package mysource.Solution167;

class Solution {
    public int[] twoSum_2021_google_faster(int[] numbers, int target) {
        int[] result = new int[2];
        int start = 0, end = numbers.length-1;
        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum > target) {
                end--;
            } else if (sum < target)
                start++;
            else {
                result[0] = start+1;
                result[1] = end+1;
                return result;
            }
        }
        return result;
    }
    public int[] twoSum_2021_google(int[] numbers, int target) {
        int[] result = new int[2];
        for ( int i = 0 ; i < numbers.length ; i++ ) {
            int second = findIndex(numbers, target-numbers[i], i);
            if(second != -1) {
                result[0] = i+1;
                result[1] = second+1;
                return result;
            }
                
        }
        return result;
    }
    
    private int findIndex(int[] numbers, int target, int index) {
        int start = 0, end = numbers.length-1;
        while(start <= end) {
            int mid = (end-start)/2 + start;
            if (numbers[mid] == target) {
                if (mid == index) {
                    if (index == 0)
                        return mid+1;
                    if (index == numbers.length-1)
                        return mid-1;
                    if (numbers[mid-1] == target)
                        return mid-1;
                    if (numbers[mid+1] == target)
                        return mid+1;
                }
                return mid;
            } else if (numbers[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }


    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        result[0] = 0;
        result[1] = 0;
        if ( target == 0 ) {
            result[0] = 1;
            result[1] = 2;
        }

        for ( int i = 0 ; i < numbers.length ; i++ ) {
            if ( (i != numbers.length - 1) && !(numbers[i] == 0 && numbers[i+1] == 0) ) {
                for ( int j = i+1 ; j < numbers.length ; j++ ) {
                    if ( (numbers[i]+numbers[j]) == target ) {
                        result[0] = i+1;
                        result[1] = j+1;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {2,7,11,15};
        int[] results = solution.twoSum(test, 9);
        for ( int result : results ) {
            System.out.println(result);
        }
        int[] test1 = {0,0,3,4};
        results = solution.twoSum(test1, 0);
        for ( int result : results ) {
            System.out.println(result);
        }

        int[] test2 = {0,1,3,4};
        results = solution.twoSum(test2, 1);
        for ( int result : results ) {
            System.out.println(result);
        }

        int[] test3 = {1,2,3,4,4,9,56,90};
        results = solution.twoSum(test3, 8);
        for ( int result : results ) {
            System.out.println(result);
        }

    }
}