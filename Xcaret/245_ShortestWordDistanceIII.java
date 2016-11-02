public class Solution {
    /**
     *  Idea -> Treat it differently. Consider word1==word2 and word1!=word2 as differenct cases.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int minGap = Integer.MAX_VALUE;
        int i1 = -1;
        int i2 = -1;
        
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(word2))  {
                if (words[i].equals(word1)) {
                    if (i1 == -1) {
                        i1 = i;
                    } else if (i2 == -1) {
                        i2 = i;
                        minGap = Math.min(minGap, i2 - i1);
                        i1 = i;
                        i2 = -1;
                    }
                }
            } else {
                if (words[i].equals(word1)) {
                    i1 = i;
                    if (i2 != -1) minGap = Math.min(minGap, i1 - i2);
                } else if (words[i].equals(word2)) {
                    i2 = i;
                    if (i1 != -1) minGap = Math.min(minGap, i2 - i1);
                }
            }
        }   
        
        return minGap;
    }
}
