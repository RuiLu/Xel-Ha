public class Solution {
    /**
     *  Divide into two cases
     *  Time complexity -> O(n)
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length <= 1 || word1 == null || word2 == null) return 0;
        
        int idx1 = -1;
        int idx2 = -1;
        int minDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(word2)) {
                if (words[i].equals(word1)) {
                    if (idx1 == -1) {
                        idx1 = i;
                    } else {
                        idx2 = idx1;
                        idx1 = i;
                    }
                }   
            } else {
                if (words[i].equals(word1)) idx1 = i;
                if (words[i].equals(word2)) idx2 = i;
            }
            
            if (idx1 != -1 && idx2 != -1) minDist = Math.min(minDist, Math.abs(idx1-idx2));
        }
        
        return minDist;
    }
}
