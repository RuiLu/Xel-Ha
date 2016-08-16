/**
 *  <isChanged> is used to save time
 *  After both indexes are found, only one of the indexes changes, res will be recalculated. 
 */
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int firstIndex = -1;
        int secondIndex = -1;
        boolean isChanged = false;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                isChanged = true;
                firstIndex = i;
            }
            if (words[i].equals(word2)) {
                isChanged = true;
                secondIndex = i;
            }
            if (firstIndex != -1 && secondIndex != -1 && isChanged) {
                res = Math.min(res, Math.abs(firstIndex - secondIndex));
                isChanged = false;
            }
        }
        
        return res;
    }
}
