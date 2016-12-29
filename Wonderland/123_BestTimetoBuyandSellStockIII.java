
/*
    1. firstBuy   -> negative, but as max as possible
    2. firstSell  -> as much as possible
    3. secondBuy  -> same
    4. secondSell -> same
*/
public class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, secondBuy = Integer.MIN_VALUE;
        int firstSell = 0, secondSell = 0;
        
        for (int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        
        return secondSell;
    }
}
