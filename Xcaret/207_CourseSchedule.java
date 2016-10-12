public class Solution {
    /**
     *  Idea -> DFS + backtracking, if we change set to boolean[], will speed up.
     *          1. create a graph, store it in List<List<Integer>>
     *          2. check if there exists a circle from 0 to n-1
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) return false;
        
        List<List<Integer>> schedule = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) schedule.add(new ArrayList<>());
        for (int[] pre : prerequisites) schedule.get(pre[1]).add(pre[0]);
        
        boolean[] ok = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (schedule.get(i).size() == 0) continue;
            boolean[] visited = new boolean[numCourses];
            if (hasCircle(schedule, visited, ok, i)) return false;
        }
        
        return true;
    }
    
    private boolean hasCircle(List<List<Integer>> schedule, boolean[] visited, boolean[] ok, int idx) {
        if (visited[idx]) return true;
        if (ok[idx]) return false;
        
        visited[idx] = true;
        for (int next : schedule.get(idx)) {
            if (hasCircle(schedule, visited, ok, next)) return true;
        }
        visited[idx] = false; 
        ok[idx] = true;    //  no circle exists starting from course idx.
        return false;
    }
    
    /**
     *  Second Idea -> used a int status[] to indicate status
     *                 0 -> unvisited; 1 -> visiting; 2 -> visited
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) return false;
        
        List<List<Integer>> schedule = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) schedule.add(new ArrayList<>());
        for (int[] pre : prerequisites) schedule.get(pre[1]).add(pre[0]);
        
        int[] status = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCircle(schedule, status, i)) return false;
        }
        
        return true;
    }
    
    private boolean hasCircle(List<List<Integer>> schedule, int[] status, int idx) {
        status[idx] = 1;
        for (int next : schedule.get(idx)) {
            if (status[next] == 1) return true;
            if (status[next] == 0) {
                if (hasCircle(schedule, status, next)) return true;
            }
        }
        status[idx] = 2;
        return false;
    }
}
