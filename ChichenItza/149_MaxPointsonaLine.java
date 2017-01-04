/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     *  Idea -> Let's assume a straight line y=ax+b, if two points are on this line,
     *          then these two formulas should be satisfied: y1=ax1+b, y2=ax2+b.
     *          Now we can get a=(y2-y1)/(x2-x1).
     *          Then we can deduct that 
     *                  (y3-y1)/(x3-x1) = (y2-y1)/(x2-x1) = a 
     *          is the condition to make sure three points are on the same straight line.
     * 
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(n^2)
     */
    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;
        
        // Outer key is diff-x, and inner key is diff-y
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int res = 0;
        
        for (int i = 0; i < points.length - 1; i++) {
            map.clear();        // Should clear map every round, because we check point one by one.
            int samePoint = 1;
            int max = 0;
            
            for (int j = i+1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                
                // If these two points are the same points
                if (x == 0 && y == 0) {
                    samePoint++;
                    continue;
                }
                
                int gcd = getGcd(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                
                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y)+1);
                    } else {
                        map.get(x).put(y, 1);
                    }
                } else {
                    HashMap<Integer, Integer> subMap = new HashMap<>();
                    subMap.put(y, 1);
                    map.put(x, subMap);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            
            // The number of samePoint must be considered.
            res = Math.max(res, max+samePoint);
        }
        
        return res;
    }
    
    private int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
}
