public class Solution {
    /**
     *  Idea -> make two strings have same length, shorter one fills will "0"
     *  Time complexity -> O(n)
     */
    public int compareVersion(String version1, String version2) {
        // if we want to split a string by ".", we need to write in this format "\\."
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int maxLen = Math.max(v1.length, v2.length);
        
        for (int i = 0; i < maxLen; i++) {
            int n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            if (n1 > n2) return 1;
            else if (n1 < n2) return -1;
        }
        
        return 0;
    }
}
