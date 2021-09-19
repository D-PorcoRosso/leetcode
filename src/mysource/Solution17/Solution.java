package mysource.Solution17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public List<String> letterCombinations_2021(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        
        HashMap<Character, List<String>> mapping = new HashMap<>();
        mapping.put('2',new ArrayList<>(Arrays.asList("a","b","c")));
        mapping.put('3',new ArrayList<>(Arrays.asList("d","e","f")));
        mapping.put('4',new ArrayList<>(Arrays.asList("g","h","i")));
        mapping.put('5',new ArrayList<>(Arrays.asList("j","k","l")));
        mapping.put('6',new ArrayList<>(Arrays.asList("m","n","o")));
        mapping.put('7',new ArrayList<>(Arrays.asList("p","q","r","s")));
        mapping.put('8',new ArrayList<>(Arrays.asList("t","u","v")));
        mapping.put('9',new ArrayList<>(Arrays.asList("w","x","y","z")));
        
        int count = digits.length();
        char[] digitsArray = digits.toCharArray();
        
        if (count == 1)
            return mapping.get(digitsArray[0]);
        
        List<String> results = mapping.get(digitsArray[0]);
        int index = 1;
        while(index < count) {
            List<String> tempResult = new ArrayList<>();
            for ( String result : results ) {
                for ( String target : mapping.get(digitsArray[index]) ) {
                    tempResult.add(result+target);
                }
            }
            results = tempResult;
            index++;
        }
        return results;
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> mapping = new HashMap<>();
        List<String> output = new ArrayList<>();
        if ( digits.length() == 0 )
            return output;
        mapping.put(2, "abc");
        mapping.put(3, "def");
        mapping.put(4, "ghi");
        mapping.put(5, "jkl");
        mapping.put(6, "mno");
        mapping.put(7, "pqrs");
        mapping.put(8, "tuv");
        mapping.put(9, "wxyz");
        List<List<String>> input = new ArrayList<>();
        for (int i = 0 ; i < digits.length() ; i++) {
            int num = Integer.parseInt(Character.toString(digits.charAt(i)));
            if ( num == 1)
                continue;
            String temp = mapping.get(num);
            List<String> sp = new ArrayList<>();
            for (int j = 0 ; j < temp.length() ; j++) {
                sp.add(Character.toString(temp.charAt(j)));
            }
            input.add(sp);
        }
        System.out.println(input);
        if ( input.size() == 0 )
            return output;

        List<String> initString = input.get(0);
        for (int i = 0 ; i < initString.size() ; i++) {
            output.add(initString.get(i));
        }
        System.out.println(output);
        for (int i = 1 ; i < input.size() ; i++) { 
            List<String> inner = input.get(i);
            List<String> outputCopy = new ArrayList(output);
            output.clear();
            for (int j = 0 ; j < outputCopy.size() ; j++ ) {
                for ( int k = 0 ; k < inner.size() ; k++ ) {
                    output.add(outputCopy.get(j)+inner.get(k));
                }
            }
        }
        
        return output;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.letterCombinations("2133"));
        System.out.println(solution.letterCombinations(""));
        System.out.println(solution.letterCombinations("1"));
    }
}