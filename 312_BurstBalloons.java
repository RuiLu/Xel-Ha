public class Solution {
    /**
     *  Divide and Conquer 
     *  Reference -> https://discuss.leetcode.com/topic/30746/share-some-analysis-and-explanations
     *  We need reverse thinking here, we need to start from bursting the last balloon.
     * 
     *  Time complexity -> O(n^3)
     */
    public int maxCoins(int[] nums) {
        // initialize the complete array, including (-1) and (n)
        int[] cnums = new int[nums.length + 2];
        int n = 1;
        for (int num : nums) {
            if (num > 0) cnums[n++] = num;
        }
        
        // initialize the start and the end
        cnums[0] = 1;
        cnums[n] = 1;
        
        // need memorization to reduce time
        int[][] memo = new int[n+1][n+1];
        
        return burst(cnums, memo, 0, n);
    }
    
    private int burst(int[] cnums, int[][] memo, int left, int right) {
        if (left + 1 == right) return 0;
        
        if (memo[left][right] > 0) return memo[left][right];
        
        int res = 0;
        // when iterating, we should skip LEFT and RIGHT, since there are already calculated in previous round
        for (int i = left + 1; i < right; i++) {
            res = Math.max(res, cnums[left] * cnums[i] * cnums[right] +
                                burst(cnums, memo, left, i) +
                                burst(cnums, memo, i, right));
        }
        
        memo[left][right] = res;
        
        return res;
    }
    
    /**
     *  DFS + Backtracking -> Time complexity -> O(n!) -> TLE!!
     */
    // public int maxCoins(int[] nums) {
    //     if (nums == null || nums.length == 0) return 0;
    //     if (nums.length == 1) return nums[0];
        
    //     List<Integer> list = new ArrayList<>();
    //     for (int num : nums) list.add(num);
        
    //     return dfs(list);
    // }
    
    // private int dfs(List<Integer> list) {
    //     if (list.size() == 1) return list.get(0);
        
    //     int res = Integer.MIN_VALUE;
    //     int len = list.size();
        
    //     for (int i = 0; i < len; i++) {
    //         int tmp = 0;
    //         int curr = list.get(i);
            
    //         if (i == 0) tmp = curr * list.get(1);
    //         else if (i == len - 1) tmp = curr * list.get(i - 1);
    //         else tmp = curr * list.get(i - 1) * list.get(i + 1);
            
    //         list.remove(i);
    //         res = Math.max(res, tmp + dfs(list));
    //         list.add(i, curr);
    //     }
        
    //     return res == Integer.MIN_VALUE ? 0 : res;
    // }
}
