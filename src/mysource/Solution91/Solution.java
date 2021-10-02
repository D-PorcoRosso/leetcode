package mysource.Solution91;

public class Solution {

    public int numDecodings_2021_250(String s) {
        if (s.startsWith("0"))
            return 0;
        
        int[] dpTable = new int[s.length()];
        for ( int i = 0 ; i < dpTable.length ; i++ )
            dpTable[i] = -1;
        
        return findDecodingCount(s.toCharArray(), dpTable, 0);
    }
    
    private int findDecodingCount(char[] nums, int[] dpTable, int index) {
        if (index == nums.length)
            return 1;
        if (index == nums.length-1) {
            if (isValid(Character.toString(nums[index]))) {
                dpTable[index] = 1;
            } else
                dpTable[index] = 0;
            return dpTable[index];
        }
        
        if (dpTable[index] != -1)
            return dpTable[index];
        
        char c1 = nums[index], c2 = nums[index+1];
        String combine = new StringBuilder().append(c1).append(c2).toString();
        if (isValid(Character.toString(c1)) && isValid(combine)) {
            dpTable[index] = findDecodingCount(nums, dpTable, index+1) + findDecodingCount(nums, dpTable, index+2);
            return dpTable[index];
        }
        
        if (isValid(Character.toString(c1))) {
            dpTable[index] = findDecodingCount(nums, dpTable, index+1);
            return dpTable[index];
        }
        
        dpTable[index] = 0;
        return dpTable[index];
    }
    
    private boolean isValid(String s) {
        if (s.startsWith("0")) {
            return false;
        }
        int target = Integer.parseInt(s);
        if (1 <= target && target <= 26)
            return true;
        return false;
    }

    public int numDecodings(String s) {
        char[] array = s.toCharArray();
        int[] dpTable = new int[array.length];
        for ( int i = 0 ; i < dpTable.length ; i++ ) {
            dpTable[i] = -1;
        }
        return isValid(array, dpTable, array.length -1);
    }
    
    private int isValid (char[] array, int[] dpTable, int index) {
        if (index < 0) {
            return 1;
        }
        if (index == 0) {
            dpTable[0] = array[0] == '0' ? 0 : 1;
            return dpTable[0];
        }
        int mappingOne = array[index] == '0' ? -1 : Integer.parseInt(""+array[index]);
        int mappingTwo = array[index-1] == '0' ? -1 : Integer.parseInt(new StringBuilder().append(array[index-1]).append(array[index]).toString());
        if (index == 1) {
            if (pass(mappingOne) && pass(mappingTwo)) {
                dpTable[1] = 2;
            }
            else if (!pass(mappingOne) && pass(mappingTwo)) {
                dpTable[1] = 1;
            }
            else if (pass(mappingOne) && !pass(mappingTwo)){
                if (dpTable[index-1] == -1) {
                    dpTable[index] = isValid(array, dpTable, index-1);
                }
            } else {
                dpTable[1] = 0;
            }
            return dpTable[1];
        }
        
        if (pass(mappingOne) && pass(mappingTwo)) {
            if (dpTable[index-1] == -1) {
                dpTable[index-1] = isValid(array, dpTable, index-1);
            }
            
            if (dpTable[index-2] == -1) {
                dpTable[index-2] = isValid(array, dpTable, index-2);
            }
            return dpTable[index-1] + dpTable[index-2];
        }
        if (pass(mappingOne) && !pass(mappingTwo)) {
            if (dpTable[index-1] == -1) {
                dpTable[index-1] = isValid(array, dpTable, index-1);
            }
            return dpTable[index-1];
        }
        if (!pass(mappingOne) && pass(mappingTwo)) {
            if (dpTable[index-2] == -1) {
                dpTable[index-2] = isValid(array, dpTable, index-2);
            }
            return dpTable[index-2];
        }
        return 0;
    }
    
    private boolean pass(int mappingIndex) {
        if (mappingIndex < 0 || mappingIndex > 26)
            return false;
        return true;
    }
}
