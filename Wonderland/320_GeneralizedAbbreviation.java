public class Solution {
    
    /**
     *  Old way for backtracking, however, need to understand the meaning of subject
     *  Time complexity -> O(2^n), since every char has two choices
     */
    // public List<String> generateAbbreviations(String word) {
    
    // }
    
    /**
     *  Bit manipulation
     *  Time complexity -> O(2^n*m) (the length of bit expression of the given word, m is the length of word)
     */
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null) return res;
        int len = 1 << word.length();
        for (int i = 0; i < len; i++) {
            res.add(helper(word, i));
        }
        return res;
    }
    
    private String helper(String word, int num) {
        StringBuilder sb = new StringBuilder();
        int consecutiveOnes = 0;
        
        for (int i = 0; i < word.length(); i++) {
            int bit = (num >> i) & 1;
            if (bit == 1) {
                consecutiveOnes++;
            } else {
                if (consecutiveOnes != 0) {
                    sb.append(consecutiveOnes);
                    consecutiveOnes = 0;
                }
                sb.append(word.charAt(i));
            }
        }
        
        if (consecutiveOnes != 0) sb.append(consecutiveOnes);
        
        return sb.toString();
    }
}
