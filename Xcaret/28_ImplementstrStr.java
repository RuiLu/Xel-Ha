public class Solution {
    /**
     *  Implement the above API
     *  Time complexity -> O(n^2)
     */
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
		int nLen = needle.length();
		
		if (hLen < nLen) return -1;
		if (nLen == 0) return 0;
		
		for (int i = 0; i <= hLen - nLen; i++) {
			if (needle.equals(haystack.substring(i, i + nLen))) return i;
		}
		
		return -1;
    } 
}
