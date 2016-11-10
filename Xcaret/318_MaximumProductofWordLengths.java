public class Solution {
    /**
     *  Idea -> Bit manipulation
     *  Reference -> https://discuss.leetcode.com/topic/35539/java-easy-version-to-understand
     *  Self explanation -> int has 32-bits, we can use the lower 26 bit to express characters from 'a' to 'z'
     *                      for example, if the lowest bit is set to 1, means that this word has at least one 'a'
     *                      so when comparing, we just need to do 'and' operation between two words, see if result is 0
     */
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        
        int len = words.length;
        int[] bitCount = new int[len];
        int maxLength = 0;
        
        for (int i = 0; i < len; i++) {
            String word = words[i];
            for (char ch : word.toCharArray()) {
                bitCount[i] |= 1 << (ch - 'a');
            }
        }
        
        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len; j++) {
                if ((bitCount[i] & bitCount[j]) == 0) {
                    maxLength = Math.max(maxLength, words[i].length() * words[j].length());
                }
            }
        }
        
        return maxLength;
    }
}
