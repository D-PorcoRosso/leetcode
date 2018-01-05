import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for ( int i = left ; i <= right ; i++ ) {
            boolean isSelf = true;
            String target = Integer.toString(i);
            for ( int j = 0 ; j < target.length() ; j++ ) {
                char dividerC = target.charAt(j);
                int dividerN = Character.getNumericValue(dividerC);
                if ( dividerN == 0 || i % dividerN != 0 ) {
                    isSelf = false;
                    break;
                }
            }
            if ( isSelf )
                result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.selfDividingNumbers(1, 22));
        System.out.println(solution.selfDividingNumbers(1, 2));
        System.out.println(solution.selfDividingNumbers(1, 10000));
    }
}