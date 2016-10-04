public class Solution {
    /**
     *  Simple
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        
        char[] sca = s.toLowerCase().toCharArray();
        int lo = 0;
        int hi = sca.length - 1;
        
        while (lo < hi) {
            while (lo < hi && !Character.isLetterOrDigit(sca[lo])) {
                lo++;
            }
            while (lo < hi && !Character.isLetterOrDigit(sca[hi])) {
                hi--;
            }
            
            if (lo >= hi) break;
            if (sca[lo] != sca[hi]) return false;
            
            lo++;
            hi--;
        }
        
        return true;
    }
}
