public class Solution {
    /**
     *  Idea -> Bucket sort
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        
        int len = citations.length;
        int[] nums = new int[len+1];
        int total = 0;
        
        for (int citation : citations) {
            if (citation > len) nums[len]++;
            else nums[citation]++;
        }
        
        for (int i = len; i > 0; i--) {
            total += nums[i];
            if (total >= i) return i;
        }
        
        return 0;
    }
}
