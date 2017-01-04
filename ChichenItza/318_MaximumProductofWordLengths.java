public class Solution {
    /**
     *  Idea -> Bit manipulation. 
     *          Use array instead of HashMap can significantly reduce speed.
     *  Time complexity -> O(n^2)
     *  Space complexity -> O(n)
     */
    public int maxProduct(String[] words) {
        if (words == null || words.length <= 1) return 0;
        
        int[] values = new int[words.length];
        int res = 0;
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int value = 0;
            for (char ch : word.toCharArray()) {
                value |= (1 << (ch-'a'));
            }
            values[i] = value;
        }
        
        for (int i = 0; i < values.length-1; i++) {
            for (int j = i + 1; j < values.length; j++) {
                int value1 = values[i];
                int value2 = values[j];
                if ((value1 & value2) == 0) res = Math.max(res, words[i].length()*words[j].length());
            }
        }
        
        return res;
    }
}
