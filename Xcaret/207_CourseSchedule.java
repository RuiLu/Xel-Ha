public class Solution {
    /**
     *  Idea -> used a int status[] to indicate status
     *          0 -> unvisited; 1 -> visiting; 2 -> visited
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
        
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) lists.add(new ArrayList<>());
        for (int[] pre : prerequisites) lists.get(pre[1]).add(pre[0]);
        
        int[] visited = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (hasCircle(lists, visited, i)) return false;
            }
        }
        
        return true;
    }
    
    private boolean hasCircle(List<List<Integer>> lists, int[] visited, int idx) {
        if (visited[idx] == 1) return true;
        
        visited[idx] = 1;
        for (int next : lists.get(idx)) {
            if (visited[next] == 1) return true;
            if (visited[next] == 0) {
                if (hasCircle(lists, visited, next)) return true;
            }
        }
        
        visited[idx] = 2;
        return false;
    }
    
    /**
     *  Idea -> DFS + backtracking, if we change set to boolean[], will speed up.
     *          1. create a graph, store it in List<List<Integer>>
     *          2. check if there exists a circle from 0 to n-1
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
        
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) lists.add(new ArrayList<>());
        for (int[] pre : prerequisites) lists.get(pre[1]).add(pre[0]);
        
        boolean[] ok = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (lists.get(i).size() == 0) continue;
            boolean[] visited = new boolean[numCourses];
            if (hasCircle(lists, visited, ok, i)) return false;
        }
        
        return true;
    }
    
    private boolean hasCircle(List<List<Integer>> lists, boolean[] visited, boolean[] ok, int idx) {
        if (visited[idx]) return true;
        if (ok[idx]) return false;
        
        visited[idx] = true;
        for (int next : lists.get(idx)) {
            if (hasCircle(lists, visited, ok, next)) return true;
        }
        visited[idx] = false;
        ok[idx] = true;
        return false;
    }
}
