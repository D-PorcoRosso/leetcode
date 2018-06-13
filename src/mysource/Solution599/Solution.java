import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for ( int i = 0 ; i < list1.length ; i++ ) {
            int count = i;
            boolean isMatch = false;
            for ( int j = 0 ; j < list2.length ; j++ ) {
                if( list1[i].equals(list2[j]) ) {
                    count += j;
                    isMatch = true;
                    break;
                }
            }
            System.out.println(i);
            System.out.println(list1[i]);
            if ( count < min && isMatch ) {
                min = count;
                result.clear();
                result.add(list1[i]);
            } else if ( count == min && isMatch ) {
                result.add(list2[count-i]);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] test1 = {"Shogun", "Tapico Express","Burger King", "KFC"};
        String[] test2 = {"KFC", "Shogun","Burger King"};
        String[] result1 = solution.findRestaurant(test2,test1);
        for ( String t : result1 ) 
            System.out.println(t);
    }
}