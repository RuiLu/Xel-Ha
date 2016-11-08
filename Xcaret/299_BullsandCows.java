public class Solution {
    /**
     *  Idea -> Use a Map to store the unmatched characters and their unmatched times according to secret.
     *          Use first traversal to construct Map, and second traversal to find the number of unmatched.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length()) return null;
        
        /* Since we have known all possible keys, we can use a array to work as Map */
        int[] map = new int[10];
        int matched = 0;
        int unmatched = 0;
        char[] sca = secret.toCharArray();
        char[] gca = guess.toCharArray();
        
        for (int i = 0; i < sca.length; i++) {
            if (sca[i] == gca[i]) {
                matched++; 
            } else {
                map[sca[i] - '0']++;
            }
        }
        
        for (int i = 0; i < sca.length; i++) {
            if (sca[i] == gca[i] || map[gca[i] - '0'] == 0) {
                continue;
            } else if (map[gca[i] - '0'] > 0) {
                map[gca[i] -'0']--;
                unmatched++;
            }
        }
        
        return matched + "A" + unmatched + "B";
    }
}
