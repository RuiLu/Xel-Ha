public class Solution {
    /**
     *  Idea -> similar with greedy
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) return 0;
        
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            maxProfit += Math.max(0, prices[i] - prices[i-1]); 
        }
        
        return maxProfit;
    }
}
