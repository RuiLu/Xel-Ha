public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            list.add(new ArrayList<>());
        }
        for (int edge[] : prerequisites) {
            list.get(edge[1]).add(edge[0]);
        }
        int[] status = new int[numCourses]; // 0->unvisited; 1->visiting; 2->visited
        for (int i = 0; i < numCourses; ++i) {
            if (existCircle(list, status, i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean existCircle(List<List<Integer>> list, int[] status, int index) {
        status[index] = 1;
        for (int next : list.get(index)) {
            if (status[next] == 1) {
                return true;
            }
            if (status[next] == 0) {
                if (existCircle(list, status, next)) {
                    return true;
                }
            }
        }
        status[index] = 2;
        return false;
    }
}
