public class Solution {
    /**
     *  Idea -> If two points are parallel to a line parallel to y-axis, then the sum of their x values are the same.
     *          For example, (-1, 1) - (3, 1) and (-3, 2) - (5, 2), these two pairs are parallel to x = 1, and the sums
     *          of their x values are equals to 2.
     *          Also, we use a id to tokenize each point.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public boolean isReflected(int[][] points) {
        if (points == null || points.length < 1) return false;
        if (points.length == 1) return true;
        
        Set<String> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            String id = point[0] + "-" + point[1];
            set.add(id);
        }
        
        int sum = max + min;
        
        for (int[] point : points) {
            String id = (sum - point[0]) + "-" + point[1];
            if (!set.contains(id)) return false;
        }
        
        return true;
    }
}
