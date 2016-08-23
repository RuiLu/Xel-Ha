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

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            for (int i = 0; i < numCourses; i++) res[i] = i;
            return res;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> incomingDegree = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) incomingDegree.put(i, 0);
        
        for (int[] prerequisite : prerequisites) {
            Set<Integer> set = new HashSet<>();
            if (map.containsKey(prerequisite[1])) set = map.get(prerequisite[1]);
            if (!set.contains(prerequisite[0])) {
                set.add(prerequisite[0]);
                map.put(prerequisite[1], set);
                incomingDegree.put(prerequisite[0], incomingDegree.get(prerequisite[0]) + 1);   
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i : incomingDegree.keySet()) {
            if (incomingDegree.get(i) == 0) queue.offer(i);
        }
        
        List<Integer> tmp = new LinkedList<>();
        
        while (!queue.isEmpty()) {
            int i1 = queue.poll();
            tmp.add(i1);
            
            if (map.containsKey(i1)) {
                for (int i2 : map.get(i1)) {
                    incomingDegree.put(i2, incomingDegree.get(i2) - 1);
                    if (incomingDegree.get(i2) == 0) queue.offer(i2);
                }
            }
        }
        
        if (tmp.size() != numCourses) return new int[0]; // has cycle
        
        for (int i = 0; i < numCourses; i++) res[i] = tmp.get(i);
        
        return res;
    }

}
