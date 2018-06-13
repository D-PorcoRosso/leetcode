package mysource.Solution28;

class Solution {

    public int strStr_by_indexof(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    public int strStr(String haystack, String needle) {
        if (haystack.equals("") && needle.equals("") ) {
            return 0;
        } else if ( haystack.equals("") && !needle.equals("") ) {
            return -1;
        } else if ( !haystack.equals("") && needle.equals("") )
            return 0;
        
        int j = 0, start = -1, hLength = haystack.length(), nLength = needle.length();

        if ( nLength > hLength )
            return -1;

        for (int i = 0 ; i < hLength ; ) {
            if ( haystack.charAt(i) == needle.charAt(j) ) {
                if ( start == -1 ) 
                    start = i;
                i++;
                j++;
                if ( j == nLength )
                    break;
            } else {
                if ( j > 0 && j < nLength ) {
                    i = start + 1;
                } else {
                    i++;
                }
                start = -1;
                j=0;
            }
        }
        if ( j != nLength )
            return -1;
        return start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String t1_1 = "" , t1_2 = "";
        String t2_1 = "abc" , t2_2 = "a";
        String t3_1 = "abc" , t3_2 = "b";
        String t4_1 = "abc" , t4_2 = "c";
        String t5_1 = "abcdede" , t5_2 = "de";
        String t6_1 = "de" , t6_2 = "abcdede";
        String t7_1 = "de" , t7_2 = "decdede";
        String t8_1 = "decdede" , t8_2 = "decdede";
        String t9_1 = "a" , t9_2 = "";
        String t10_1 = "mississippi", t10_2 = "issip";
        String t11_1 = "mississippi", t11_2 = "issipi";
        String t12_1 = "mississippi", t12_2 = "pi";

        assert (solution.strStr(t1_1,t1_2) == 0 ) : "error";
        System.out.println("1 true");
        assert (solution.strStr(t2_1,t2_2) == 0 ) : "error";
        System.out.println("2 true");
        assert (solution.strStr(t3_1,t3_2) == 1 ) : "error";
        System.out.println("3 true");
        assert (solution.strStr(t4_1,t4_2) == 2 ) : "error";
        System.out.println("4 true");
        assert (solution.strStr(t5_1,t5_2) == 3 ) : "error";
        System.out.println("5 true");
        assert (solution.strStr(t6_1,t6_2) == -1 ) : "error";
        System.out.println("6 true");
        assert (solution.strStr(t7_1,t7_2) == -1 ) : "error";
        System.out.println("7 true");
        assert (solution.strStr(t8_1,t8_2) == 0 ) : "error";
        System.out.println("8 true");
        assert (solution.strStr(t9_1,t9_2) == 0 ) : "error";
        System.out.println("9 true");
        assert (solution.strStr(t10_1,t10_2) == 4 ) : "error";
        System.out.println("10 true");
        assert (solution.strStr(t11_1,t11_2) == -1 ) : "error";
        System.out.println("11 true");
        assert (solution.strStr(t12_1,t12_2) == 9 ) : "error";
        System.out.println("12 true");


        assert (solution.strStr_by_indexof(t1_1,t1_2) == 0 ) : "error";
        System.out.println("1 true");
        assert (solution.strStr_by_indexof(t2_1,t2_2) == 0 ) : "error";
        System.out.println("2 true");
        assert (solution.strStr_by_indexof(t3_1,t3_2) == 1 ) : "error";
        System.out.println("3 true");
        assert (solution.strStr_by_indexof(t4_1,t4_2) == 2 ) : "error";
        System.out.println("4 true");
        assert (solution.strStr_by_indexof(t5_1,t5_2) == 3 ) : "error";
        System.out.println("5 true");
        assert (solution.strStr_by_indexof(t6_1,t6_2) == -1 ) : "error";
        System.out.println("6 true");
        assert (solution.strStr_by_indexof(t7_1,t7_2) == -1 ) : "error";
        System.out.println("7 true");
        assert (solution.strStr_by_indexof(t8_1,t8_2) == 0 ) : "error";
        System.out.println("8 true");
        assert (solution.strStr_by_indexof(t9_1,t9_2) == 0 ) : "error";
        System.out.println("9 true");
        assert (solution.strStr_by_indexof(t10_1,t10_2) == 4 ) : "error";
        System.out.println("10 true");
        assert (solution.strStr_by_indexof(t11_1,t11_2) == -1 ) : "error";
        System.out.println("11 true");
        assert (solution.strStr_by_indexof(t12_1,t12_2) == 9 ) : "error";
        System.out.println("12 true");
    }
}