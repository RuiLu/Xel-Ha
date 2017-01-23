public class Solution {
    /**
     * Idea -> Two pointers.
     * Time complexity -> O(n)
     * Space complexity -> O(1)
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int lo = 0;
        int hi = 0;
        int[] count = new int[256];
        int maxLen = 0;
        
        while (hi < s.length()) {
            /* if the character is unique in the current range, add this character to count */
            if (count[s.charAt(hi)] == 0) {
                count[s.charAt(hi)]++;
            } else { /* Otherwise, move lo pointers rightward until all characters in unique in the range */
                while (lo <= hi && s.charAt(lo) != s.charAt(hi)) {
                    count[s.charAt(lo++)]--;
                }
                lo++;
            }
            hi++;
            maxLen = Math.max(maxLen, hi-lo);
        }
        
        return maxLen;
    }
}
