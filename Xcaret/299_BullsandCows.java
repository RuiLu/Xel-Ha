public class Solution {
    /**
     *  Idea -> Use a Map to store the unmatched characters and their unmatched times according to secret.
     *          Use first traversal to construct Map, and second traversal to find the number of unmatched.
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length()) return "";
        
        char[] sca = secret.toCharArray();
        char[] gca = guess.toCharArray();
        int matched = 0;
        int unmatched = 0;
        int[] map = new int[10];
        
        /* First round, count matched number, and create map, counting elements that in secret while not in guess */
        for (int i = 0; i < sca.length; i++) {
            if (sca[i] == gca[i]) {
                matched++;
            } else {
                map[sca[i]-'0']++;
            }
        }
        
        /* Second round, count unmathced number, counting element both in secret and guess but not matched */
        for (int i = 0; i < sca.length; i++) {
            if (sca[i] == gca[i] || map[gca[i]-'0'] == 0) {
                continue;
            } else if (map[gca[i]-'0'] > 0) {
                map[gca[i]-'0']--;
                unmatched++;
            }
        }
        
        return matched + "A" + unmatched + "B";
    }
}
