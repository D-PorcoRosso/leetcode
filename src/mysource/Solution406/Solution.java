class Solution {
    public int[][] bubbleSort(int[][] nums) {
        for ( int i = 0 ; i < nums.length ; i++ ) {
            boolean isSwap = false;
            for ( int j = 0 ; j < nums.length-1 ; j++ ) {
                if ( nums[j][0] > nums[j+1][0] ) {
                    int[] temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                    isSwap = true;
                }
            }
            if ( !isSwap )
                break;
        }
        return nums;
    }

    public int[][] reconstructQueue(int[][] people) {
        bubbleSort(people);
        for ( int[] p : people ) {
            
        }
        return people;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test = { {7,0},{4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result = solution.reconstructQueue(test);
        for ( int[] r : result ) {
            for ( int n : r ) {
                System.out.print(n+",");
            }
            System.out.println("");
        }
    }
}