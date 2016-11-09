public class Solution {
    /**
     *  Idea -> Divide and Conquer
     *          We need reverse thinking here, we need to start from bursting the last balloon.
     *  Reference -> https://discuss.leetcode.com/topic/30746/share-some-analysis-and-explanations
     *  Time complexity -> O(n^3)
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int[] cnums = new int[nums.length+2];
        
        int n = 1;
        for (int num : nums) cnums[n++] = num;
        cnums[0] = 1;
        cnums[n] = 1;
        
        int[][] map = new int[n+1][n+1];
        
        return burstBalloons(cnums, map, 0, n);
    }
    
    private int burstBalloons(int[] cnums, int[][] map, int left, int right) {
        if (left + 1 == right) return 0;
        if (map[left][right] > 0) return map[left][right];
        
        int res = 0;
        
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, cnums[left] * cnums[i] * cnums[right] +
                                burstBalloons(cnums, map, left, i) +
                                burstBalloons(cnums, map, i, right));
        }
        
        map[left][right] = res;
        return res;
    }
}
