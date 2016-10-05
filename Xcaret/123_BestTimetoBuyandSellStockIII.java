public class Solution {
    /**
     *  Idea -> 
     *      1. firstBuy  -> initialize it to Integer.MIN_VALUE, which is negative, so as much as possible
     *      2. firstSell -> as much as possible
     *      3. secondBuy -> same as firstBuy
     *      4. secondSell-> same as firstSell
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;
        
        for (int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        
        return secondSell;
    }
}
