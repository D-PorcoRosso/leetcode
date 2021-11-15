package mysource.Solution554;

public class Solution {
    public int leastBricks_2021_google(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<wall.size();i++){
            List<Integer> li=wall.get(i);
            int sum=0;
            
            for(int j = 0 ; j < li.size()-1 ; j++) {
                sum+=li.get(j);
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int ans=0;
        for(int val:map.keySet()){
            ans=Math.max(map.get(val),ans);
        }
        
        return wall.size()-ans;
    }

    public int leastBricks_2021_google_TLE(List<List<Integer>> wall) {
        int length = 1;
        for ( int index : wall.get(0) ) {
            length += index;
        }
        int[][] walls = new int[wall.size()][length];
        for ( int i = 0 ; i < wall.size() ; i++ ) {
            for (int j = 0 ; j < length ; j++ ) 
                walls[i][j] = 1;
            int sum = 0;
            for (int index : wall.get(i)) {
                sum += index;
                if (sum != length-1)
                    walls[i][sum] = 0;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for ( int i = 0 ; i < length ; i++ ) {
            int cross = 0;
            for (int j = 0 ; j < wall.size() ; j++) {
                if (walls[j][i] == 1)
                    cross++;
            }
            min = Math.min(min, cross);
        }
        return min;
    }
}
