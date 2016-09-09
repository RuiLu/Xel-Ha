/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
/**
 *  A straight line can be expressed as y=ax+b
 *  So, if two points are in the same line, should satisfy y1=ax1+b and y2=ax2+b,
 *  ->  (y1 - y2) = a(x1 - x2) -> (y1 - y2) / (x1 - x2) = a.
 *  ->  y0 / x0 = (y3 - y1) / (x3 - x1) = (y2 - y1) / (x2 - x1) = a
 *  ->  we need to find the gcd of (ya - yb) and (xa - xb)
 *  
 *  Reference -> https://discuss.leetcode.com/topic/2979/a-java-solution-with-notes
 * 
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null ) return 0;
        if (points.length <= 2) return points.length;
        
        int res = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int sameP = 1;
            int max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                
                if (x == 0 && y == 0) {
                    sameP++;
                    continue;
                }
                
                int gcd = getGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                
                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) map.get(x).put(y, map.get(x).get(y) + 1);
                    else map.get(x).put(y, 1);
                } else {
                    Map<Integer, Integer> subMap = new HashMap<>();
                    subMap.put(y, 1);
                    map.put(x, subMap);
                }
                
                max = Math.max(max, map.get(x).get(y));
             }
             
             res = Math.max(res, max + sameP);
        }
        
        return res;
    }
    
    private int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}
