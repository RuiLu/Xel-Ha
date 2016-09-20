public class Solution {
    /**
     *  Using String API directly
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle, 0);
    }
    
    /**
     *  Implement the above API
     */
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        
        if (hLen < nLen) return -1;
        else if (nLen == 0) return 0;
        
        for (int i = 0; i <= hLen - nLen; i++) {
            if (haystack.substring(i, i + nLen).equals(needle)) return i;
        }
        
        return -1;
    } 
}
