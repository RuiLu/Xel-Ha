public class Solution {
    /**
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(n)
     */
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        
        int res = 0;
        /* Create a HashMap, key is the distance, value is the number of pairs with the same distance */
        HashMap<Long, Integer> map = new HashMap<>();
        
        for (int i = 0; i < points.length; i++) {
            /* Note that we must clear HashMap before every round */
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                /* Distancn is Long in order to avoid Integer Overflow */
                long dist = getDistance(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist,0)+1);
            }
            
            /* A boomerangs is a tuple of three element, becouse the start point is fixed, */
            /* so we only consider combinations for other two points, the result is n!/(n-2)! */
            for (int value : map.values()) {
                res += value*(value-1);
            }
        }
        
        return res;
    }
    
    private long getDistance(int[] p1, int[] p2) {
        return (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}
