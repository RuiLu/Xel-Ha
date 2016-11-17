public class Solution {
    /**
     *  Idea -> Scan the array once, and update the minGap during scanning
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int minGap = Integer.MAX_VALUE;
        int i1 = -1;
        int i2 = -1;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
                if (i2 != -1) minGap = Math.min(minGap, i1 - i2);
            } else if (words[i].equals(word2)) {
                i2 = i;
                if (i1 != -1) minGap = Math.min(minGap, i2 - i1);
            }
        }
        
        return minGap;
    } 

}
