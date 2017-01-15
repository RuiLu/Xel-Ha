public class Solution {
    /**
     * Idea -> Update matching words' indices idx1 and idx2. Compare them when there are both not -1.
     * Time complexity -> O(n)
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2 || word1 == null || word2 == null) return 0;
        
        int idx1 = -1;
        int idx2 = -1;
        int minDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) idx1 = i;
            if (words[i].equals(word2)) idx2 = i;
            if (idx1 != -1 && idx2 != -1) minDist = Math.min(minDist, Math.abs(idx1-idx2));
        }
        
        return minDist;
    }
}
