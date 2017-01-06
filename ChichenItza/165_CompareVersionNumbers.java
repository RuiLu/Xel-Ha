public class Solution {
    /**
     *  Idea -> According to the subject, let's assume that the input versions are always valid.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */ 
    public int compareVersion(String version1, String version2) {
        /* The regex for matching "." is "\\." */
        String[] tokens1 = version1.split("\\.");
        String[] tokens2 = version2.split("\\.");
        
        /* We obtain the longer length between tokens1 and tokens2*/
        int len = Math.max(tokens1.length, tokens2.length);
        
        for (int i = 0; i < len; i++) {
            /* If the index is bigger than the length, assign number to 0 directly, so only one loop is need. */
            long num1 = i < tokens1.length ? Long.parseLong(tokens1[i]) : 0;
            long num2 = i < tokens2.length ? Long.parseLong(tokens2[i]) : 0;
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
        }
        
        return 0;
    }
}
