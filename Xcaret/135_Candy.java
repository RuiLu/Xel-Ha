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
        
        int num = 0;
        int len = ratings.length;
        int[] candies = new int[len];

        // first round -> assign each kid one candy
        for (int i = 0; i < len; i++) {
            candies[i] = 1;            
        }
        
        // second round -> from left to right, if previous rating if smaller, give one more candy to latter one
        for (int i = 0; i < len - 1; i++) {
            if (ratings[i+1] > ratings[i]) {
                candies[i+1] = candies[i] + 1;
            }
        }
        
        // third round -> do the same thing as the second round except that this time starts from right
        for (int i = len - 1; i > 0; i--) {
            if (ratings[i-1] > ratings[i] && candies[i-1] <= candies[i]) {
                candies[i-1] = candies[i] + 1;
            }
        }
        
        for (int candy : candies) {
            num += candy;
        }
        
        return num;
    }
}
