public class Solution {
    /**
     *  Idea -> DFS
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) res[i] = i;
            return res;
        }
        
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) lists.add(new ArrayList<>());
        for (int[] pre : prerequisites) lists.get(pre[1]).add(pre[0]);
        
        int[] visited = new int[numCourses];
        LinkedList<Integer> tmp = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (hasCircle(lists, visited, tmp, i)) return new int[0];
            }
        }
        
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) res[i] = tmp.get(i);
        
        return res;
    }
    
    private boolean hasCircle(List<List<Integer>> lists, int[] visited, LinkedList<Integer> tmp, int i) {
        if (visited[i] == 1) return true;
        
        visited[i] = 1;
        for (int next : lists.get(i)) {
            if (visited[next] == 1) return true;
            if (visited[next] == 0) {
                if (hasCircle(lists, visited, tmp, next)) return true;
            }
        }
        visited[i] = 2;
        
        tmp.addFirst(i);
        return false;
    }
    
    /**
     *  Idea -> Topological sort
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) res[i] = i;
            return res;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> incomingDegrees = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) incomingDegrees.put(i, 0);
        
        for (int[] pre : prerequisites) {
            Set<Integer> set = new HashSet<>();
            if (map.containsKey(pre[1])) set = map.get(pre[1]);
            if (!set.contains(pre[0])) {
                set.add(pre[0]);
                map.put(pre[1], set);
                incomingDegrees.put(pre[0], incomingDegrees.get(pre[0]) + 1);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int key : incomingDegrees.keySet()) {
            if (incomingDegrees.get(key) == 0) queue.offer(key);
        }
        
        List<Integer> tmp = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            tmp.add(curr);
            
            if (map.containsKey(curr)) {
                for (int next : map.get(curr)) {
                    incomingDegrees.put(next, incomingDegrees.get(next) - 1);
                    if (incomingDegrees.get(next) == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        
        if (tmp.size() != numCourses) return new int[0];
        
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) res[i] = tmp.get(i);
        
        return res;
    }
}
