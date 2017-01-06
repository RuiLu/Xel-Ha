public class Solution {
    /**
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        
        int sell = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > sell) profit = Math.max(profit, prices[i] - sell);
            if (prices[i] < sell) sell = prices[i];
        }
        
        return profit;
    }
}
