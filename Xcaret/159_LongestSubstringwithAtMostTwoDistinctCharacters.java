public class Solution {
    /**
     *  Two pointers + map-like array
     *  Time complexity -> O(n) , in worst case -> O(n^2)
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int[] map = new int[128];
        int begin = 0;
        int end = 0;
        int counter = 0;
        int maxLen = Integer.MIN_VALUE;
        
        while (end < s.length()) {
            if (map[s.charAt(end)] == 0) {
                counter++;
            }
            map[s.charAt(end)]++;
            end++;
            
            while (counter > 2) {
                if (map[s.charAt(begin)] == 1) {
                    counter--;
                }    
                map[s.charAt(begin)]--;
                begin++;
            }
            
            maxLen = Math.max(maxLen, end - begin);
        }
        
        return maxLen == Integer.MAX_VALUE ? 0 : maxLen;
    }
}
