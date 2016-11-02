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
     
    /**
     *  Idea -> Keep track of index of both word1 and word2
     *  Time complexity -> O(n^2) (worst case)
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) return 0;
        
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int minGap = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) l1.add(i);
            if (words[i].equals(word2)) l2.add(i);
        }
        
        for (int i1 : l1) {
            for (int i2 : l2) {
                minGap = Math.min(minGap, Math.abs(i1 - i2));
            }
        }
        
        return minGap;
    }
}
