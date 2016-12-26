public class Solution {
    /**
     *  Idea -> Record the start position and end position
     *  Time complexity -> O(n^2) in worst case, where n is the length of input string
     */ 
    public String longestPalindrome(String s) {
		if (s == null || s.length() < 2) return s;
		
		int maxLen = 0;
		int lo = 0;
		int hi = 0;
		
		for (int i = 0; i < s.length(); i++) {
		    /* check odd length */
		    for (int j = 0; i-j >= 0 && i+j < s.length() && s.charAt(i-j) == s.charAt(i+j); j++) {
		        if (maxLen < 2 * j + 1) {
		            maxLen = 2 * j + 1;
		            lo = i - j;
		            hi = i + j;
		        }
		    }
		    
		    /* check even length */
		    for (int j = 1; i-j+1 >= 0 && i+j < s.length() && s.charAt(i-j+1) == s.charAt(i+j); j++) {
		        if (maxLen < 2 * j) {
		            maxLen = 2* j;
		            lo = i - j + 1;
		            hi = i + j;
		        }
		    }
		}
		
		return s.substring(lo, hi + 1);
    }
}
