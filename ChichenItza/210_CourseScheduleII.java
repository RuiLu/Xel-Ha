public class Solution {
    /**
     *  Idea -> Topological Sort. 
     *          We can treat each pair as a directed edge, so all pairs will form a directed graph.
     *          1. genereate degree 
     *          2. fill out map and degree
     *          3. genereate queue with node who has 0 degree
     *          4. use BFS to genereate result list, in the meantion, updating degree and 
     *             once the degree is 0, add this node to queue
     *          5. check whether all nodes are inclued in the reuslt list. If not, means that there is a circle.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        HashMap<Integer, Integer> degree = new HashMap<Integer, Integer>();
        
        /* 1. add all courses into degree map */
        for (int i = 0; i < numCourses; i++) degree.put(i, 0);
        
        /* 2. add course pairs into map and degree */
        for (int[] pre : prerequisites) {
            HashSet<Integer> set = new HashSet<Integer>();
            if (map.containsKey(pre[1])) set = map.get(pre[1]);
            if (!set.contains(pre[0])) {
                set.add(pre[0]);
                degree.put(pre[0], degree.get(pre[0]) + 1);
                map.put(pre[1], set);
            }
        }
        
        /* 3. add every course with 0 degree into queue */
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int key : degree.keySet()) {
            if (degree.get(key) == 0) queue.offer(key);
        }
        
        /* 4. do topological sort using BFS */
        LinkedList<Integer> list = new LinkedList<Integer>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            list.add(curr);
            if (map.containsKey(curr)) {
                for (int next : map.get(curr)) {
                    degree.put(next, degree.get(next) - 1);
                    if (degree.get(next) == 0) queue.offer(next);
                }
            }
        }
        
        /* 5. determine whether all courses are inclued in the list */
        if (list.size() != numCourses) return new int[0];
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}
