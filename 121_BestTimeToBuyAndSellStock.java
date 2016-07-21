/*
 Time complexity -> O(n)
 Space complexity -> O(1)
 Easy thought -> the price of current day minus the current min value.
*/
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        
        for (int price : prices) {
            if (price <= min) min = price;
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }
}
