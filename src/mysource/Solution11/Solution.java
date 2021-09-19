package mysource.Solution11;

class Solution {
    public int maxArea_2021_o_n(int[] height) {
        int max = -1;
        int i = 0, j = height.length - 1;
        while( i < j ) {
            max = Math.max(max, Math.min(height[i], height[j])*(j-i));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        // for ( int i = 0 ; i < height.length ; i++ ) {
        //     for ( int j = i+1 ; j < height.length ; j++ ){
        //         max = Math.max(max, Math.min(height[i], height[j])*(j-i));
        //     }
        // }
        return max;
    }


    // o(n)
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max = Integer.MIN_VALUE;
        while ( left < right ) {
            int localMax = Math.min(height[left],height[right]) * (right - left);
            if (localMax > max)
                max = localMax;
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }

    //O(n^2) 
    public int maxArea2021(int[] height) {
        int max = 0;
        for ( int index = 0 ; index < height.length ; index++) {
            int start = height.length, end = 0;
            for (int pivot = 0 ; pivot < height.length ; pivot++ ) {
                if (height[pivot] - height[index] >= 0 && pivot < start) {
                    start = pivot;
                }
                if (height[pivot]-height[index] >= 0 && pivot > end) {
                    end = pivot;
                }
            }
            int localMax = height[index] * (end -start);
            if (max < localMax) {
                max = localMax;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {1,2,3,4,5};
        System.out.println(solution.maxArea2021(test1));
        int[] test2 = {1,1};
        System.out.println(solution.maxArea2021(test2));
        int[] test3 = {1,2,1};
        System.out.println(solution.maxArea2021(test3));
        int[] test4 = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea2021(test4));
    }
}