public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int firstIndex = -1;
        int secondIndex = -1;
        boolean isChanged = false;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                firstIndex = i;
                isChanged = true;
            }
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    firstIndex = secondIndex;
                }
                secondIndex = i;
                isChanged = true;
            }
            if (firstIndex != -1 && secondIndex != -1 && isChanged) {
                res = Math.min(res, Math.abs(firstIndex - secondIndex));
                isChanged = false;
            }
        }
        
        return res;
    }
}
