package mysource.Solution11;

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max = Integer.MIN_VALUE;
        int rightHeight = height[right], leftHight = height[left];
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {1,2,3,4,5};
        System.out.println(solution.maxArea(test1));
        int[] test2 = {1,1};
        System.out.println(solution.maxArea(test2));
        int[] test3 = {1,2,1};
        System.out.println(solution.maxArea(test3));
    }
}