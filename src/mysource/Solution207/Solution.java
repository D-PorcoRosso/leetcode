package mysource.Solution207;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || numCourses == 1 || prerequisites.length == 0) {
            return true;
        }
        HashMap<Integer, List<Integer>> dep = new HashMap<>();
        for ( int i = 0 ; i < prerequisites.length ; i++ ) {
            List<Integer> sameDep = dep.get(prerequisites[i][0]);
            if (prerequisites[i][0] == prerequisites[i][1])
                return false;
            if (sameDep == null) {
                sameDep = new ArrayList<>();
                dep.put(prerequisites[i][0], sameDep);
            }
            sameDep.add(prerequisites[i][1]);
        }
        boolean isLoop = false;
        for ( Map.Entry<Integer, List<Integer>> d : dep.entrySet()) {
            isLoop = isLoop(0, numCourses, d.getKey(), dep) || isLoop;
        }
        return !isLoop;
    }
    
    private boolean isLoop(int count, int numCourses, int target, HashMap<Integer, List<Integer>> dep) {
        if (dep.get(target) != null ) {
            if (count == numCourses)
                return true;
            ++count;
            boolean isloop = false;
            for ( Integer t : dep.get(target)) {
                isloop = isLoop(count, numCourses, t, dep) || isloop;
            }
            return isloop;
        } else {
            return false;
        }
    }
}
