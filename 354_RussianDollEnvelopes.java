public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/47469/java-nlogn-solution-with-explanation
     *  Arrays ref -> https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#binarySearch(int[],%20int,%20int,%20int)
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;
        
        int[] dp = new int[envelopes.length];
        int len = 0;
        
        /* Ascending for width, if have same width, descending for height */
        Arrays.sort(envelopes, new Comparator<int[]>(){
           public int compare(int[] arr1, int[] arr2) {
               if (arr1[0] == arr2[0]) return arr2[1] - arr1[1];
               else return arr1[0] - arr2[0];
           } 
        });
        
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            
            if (index < 0) index = -(index + 1);
            
            dp[index] = envelope[1];
            
            if (index == len) len++;
        }
        
        return len;
    }
}
