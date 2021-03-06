public class Solution {
    /**
     *  Any negative number is not palindrome
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        String s = String.valueOf(x);
        int lo = 0;
        int hi = s.length() -1;
        
        while (lo <= hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) return false;
        }
        
        return true;
    }
}
