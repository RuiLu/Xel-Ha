public class Solution {
    /**
     *  Idea -> Draw a state machine graph, then can come out states easily
     *          The graph can be seen in reference.
     *          s0[i] = max(s0[i-1], s2[i-1])
     *          s1[i] = max(s0[i-1] - prices[i], s1[i-1])
     *          s2[i] = s1[i-1] + prices[i]
     *  Reference -> https://discuss.leetcode.com/topic/30680/share-my-dp-solution-by-state-machine-thinking
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        
        int len = prices.length;
        int[] s0 = new int[len];
        int[] s1 = new int[len];
        int[] s2 = new int[len];
        
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        
        for (int i = 1; i < len; i++) {
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s0[i-1] - prices[i], s1[i-1]);
            s2[i] = s1[i-1] + prices[i];
        }
        
        return Math.max(s0[len-1], Math.max(s1[len-1], s2[len-1]));
    }
}
