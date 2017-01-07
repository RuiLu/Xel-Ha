public class Solution {
    /**
     *  Idea -> Initialize four variables.
     *          firstBuy    -> Initialize it to Interger.MIN_VALUE, try to make it as large as possible
     *          firstSell   -> Initialize it to 0, try to make it as large as possible
     *          secondBuy   -> same as firstBuy
     *          secondSell  -> same as firstSell
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;
        
        for (int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy+price);
            secondBuy = Math.max(secondBuy, firstSell-price);
            secondSell = Math.max(secondSell, secondBuy+price);
        }
        
        return secondSell;
    }
}
