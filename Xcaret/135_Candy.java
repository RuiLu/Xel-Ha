public class Solution {
    /**
     *  Idea -> For example [1,2,2,4,2,1]
     *          First, create an array and fills it with 1 -> 1,1,1,1,1,1
     *          Second, traverse array from left to right, if ratings[i+1] > ratings[i], array[i+1] = array[i] + 1
     *                                                     -> 1,2,1,2,1,1
     *          Third, traverse array from right to left, if ratings[i-1] > ratings[i] && array[i-1] <= array[i]
     *                 do array[i-1] = array[i] + 1        -> 1,2,1,3,2,1
     *          
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        
        int res = 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i+1]) {
                candies[i+1] = candies[i] + 1;
            }
        }
        
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i-1] > ratings[i] && candies[i-1] <= candies[i]) {
                candies[i-1] = candies[i] + 1;
            } 
        }
        
        for (int candy : candies) {
            res += candy;
        }
        
        return res;
    }
}
