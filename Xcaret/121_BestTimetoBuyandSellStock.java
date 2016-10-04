public class Solution {
    /**
     *  Idea -> record the index of current minimum price
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        
        int max = 0;
        int minIdx = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[minIdx]) {
                max = Math.max(max, prices[i] - prices[minIdx]);
            } else {
                minIdx = i;
            }
        }
        
        return max;
    }
}
