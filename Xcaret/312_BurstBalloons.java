public class Solution {
    /**
     *  Idea -> Divide and Conquer
     *          We need reverse thinking here, we need to start from bursting the last balloon.
     *  Reference -> https://discuss.leetcode.com/topic/30746/share-some-analysis-and-explanations
     *  Time complexity -> O(n^3)
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int len = nums.length;
        int[] cnums = new int[len+2];
        int n = 0;
        
        cnums[n++] = 1;
        for (int num : nums) cnums[n++] = num;
        cnums[n] = 1;
        
        int[][] map = new int[n+1][n+1];
        
        return findMaxCoins(cnums, 0, n, map);
    }
    
    private int findMaxCoins(int[] cnums, int left, int right, int[][] map) {
        if (left + 1 == right) return 0;
        if (map[left][right] > 0) return map[left][right];
        
        int max = 0;
        
        for (int i = left + 1; i < right; i++) {
            max = Math.max(max, findMaxCoins(cnums, left, i, map) + 
                                cnums[left] * cnums[i] * cnums[right] +
                                findMaxCoins(cnums, i, right, map));    
        }
        
        map[left][right] = max;
        return max;
    }
}
