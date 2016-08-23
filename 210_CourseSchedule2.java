/*  stack -- topo sequence
    0 -- []
    0,1 -- []
    0,1,3 -- []
    0,1 -- [3]
    0 -- [3,1]
    0,2 -- [3,1]
    0 -- [3,1,2]
    _ -- [3,1,2,0]
*/
public class Solution {
    
    /**
     *  1. DFS 
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) lists.add(new ArrayList<>());
        
        for (int[] prerequisite : prerequisites) {
            lists.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        int[] visited = new int[numCourses];
        LinkedList<Integer> sequence = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
              if (hasCycle(sequence, visited, lists, i)) return new int[0]; 
            }
        }
        
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) res[i] = sequence.get(i);
        
        return res;
    }
    
    private boolean hasCycle(LinkedList<Integer> seq, int[] visited, List<List<Integer>> lists, int index) {
        if (visited[index] == 1) return true;
        
        visited[index] = 1;
        for (int next : lists.get(index)) {
            if (visited[next] == 1) return true;    // exist a cycle
            if (visited[next] == 0) {
                if (hasCycle(seq, visited, lists, next)) return true;
            }
        }
        
        visited[index] = 2;
        seq.addFirst(index);
        
        return false;
    }
}
