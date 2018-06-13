class Solution {
    public int findLUSlength(String a, String b) {
        if (a.isEmpty() || b.isEmpty())
            return a.length() > b.length() ? a.length() : b.length();

        if (a.contains(b) || b.contains(a))
            return -1;
        else
            return a.length() > b.length() ? a.length() : b.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLUSlength("aba","cdc"));
    }
}