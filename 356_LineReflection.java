public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/48172/simple-java-hashset-solution/2
     *  Time complexity -> O(n)
     */
    public boolean isReflected(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) return true;
        
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

