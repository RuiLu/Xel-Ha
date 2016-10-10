public class Solution {
    /**
     *  Idea -> make two strings have same length, shorter one fills will "0"
     *  Time complexity -> O(n)
     */
    public int compareVersion(String version1, String version2) {
        // we should use "\\." to split a string by "."
        String[] tokens1 = version1.split("\\.");
        String[] tokens2 = version2.split("\\.");
        
        int maxLen = Math.max(tokens1.length, tokens2.length);
        for (int i = 0; i < maxLen; i++) {
            int num1 = i < tokens1.length ? Integer.parseInt(tokens1[i]) : 0;
            int num2 = i < tokens2.length ? Integer.parseInt(tokens2[i]) : 0;
            
            if (num1 > num2) return 1;
            else if (num1 < num2) return -1;
        }
        
        return 0;
    }
}
