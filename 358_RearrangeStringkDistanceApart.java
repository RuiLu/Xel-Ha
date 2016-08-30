public class Solution {
    /**
     *  Using two arrays -> 1. count -> record the frequency of characters; 
     *                      2. valid -> record the next valid position for every character
     *  Time complexity -> O(n)
     */
    public String rearrangeString(String str, int k) {
        int len = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        
        for (char ch : str.toCharArray()) count[ch - 'a']++;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < len; i++) {
            int candidatePos = findValidMax(count, valid, i);
            if (candidatePos == -1) return "";
            count[candidatePos]--;
            valid[candidatePos] = i + k;
            sb.append((char)(candidatePos + 'a'));
        }
        
        return sb.toString();
    }

    private int findValidMax(int[] count, int[] valid, int currIndex) {
        int max = Integer.MIN_VALUE;
        int candidatePos = -1;
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] > max && currIndex >= valid[i]) {
                max = count[i];
                candidatePos = i;
            }    
        }
        
        return candidatePos;
    }

}
