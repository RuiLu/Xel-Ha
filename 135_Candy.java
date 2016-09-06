public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/37924/very-simple-java-solution-with-detail-explanation
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        
        int res = 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) candies[i + 1] = candies[i] + 1;
        }
        
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                if (candies[i - 1] < (candies[i] + 1)) candies[i - 1] = candies[i] + 1;
            } 
        }
        
        for (int candy : candies) res += candy;
        
        return res;
    }
}
