public class Solution {
    /**
     *  Idea -> Different situations:
     *          1. 1,2,3,4,5,6,... (monotonic increase)
     *          2. ...,6,5,4,3,2,1 (monotonic decrease)
     *          3. 1,2,3,7,6,4,3,5,6 (random)
     *  
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int profit = 0;
        /* Compare each continuous days */
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i]-prices[i-1]);
        }
        return profit;
    }
}
