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
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            list.get(edge[1]).add(edge[0]);
        }
        int[] status = new int[numCourses]; // 0->unvisited; 1->visiting; 2->visited
        LinkedList<Integer> topoSeq = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (status[i] == 0) {
                if (existCircle(topoSeq, list, status, i)) {
                    return new int[0];
                }
            }
        }
        int[] res = new int[topoSeq.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = topoSeq.get(i);
        }
        return res;
    }
    
    public boolean existCircle(LinkedList<Integer> topoSeq, List<List<Integer>> list, int[] status, int index) {
        status[index] = 1;
        for (int next : list.get(index)) {
            if (status[next] == 1) {
                return true;
            }
            if (status[next] == 0) {
                if (existCircle(topoSeq, list, status, next)) {
                    return true;
                }
            }
        }
        topoSeq.addFirst(index);
        status[index] = 2;
        return false;
    }
}
