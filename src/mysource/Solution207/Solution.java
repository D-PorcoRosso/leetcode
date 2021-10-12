package mysource.Solution207;

public class Solution {
    public boolean canFinish_2021_250(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> mapping = new HashMap<>();

        for ( int[] course : prerequisites ) {
            if (mapping.containsKey(course[1])) {
                mapping.get(course[1]).add(course[0]);
            } else {
                List<Integer> dep = new ArrayList<>();
                dep.add(course[0]);
                mapping.put(course[1], dep);
            }
        }
        
        Boolean[] passCourses = new Boolean[numCourses];
        
        for ( int curr = 0 ; curr < numCourses ; curr++ ) {
            if (isCycle(curr, mapping, passCourses)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isCycle(int currCourse, HashMap<Integer, List<Integer>> mapping, Boolean[] status) {
        if (status[currCourse] != null) {
            return status[currCourse];
        }
        
        if (!mapping.containsKey(currCourse)) {
            return false;
        }
        
        status[currCourse] = true;
        
        boolean isLoop = false;
        for( int next : mapping.get(currCourse) ) {
            isLoop = isCycle(next, mapping, status);
            if (isLoop)
                break;
        }
        status[currCourse] = false;
        return isLoop;
    }

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
