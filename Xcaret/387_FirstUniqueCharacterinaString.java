public class Solution {
    /**
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        
        char[] sca = s.toCharArray();
        int[] map = new int[26];
        
        for (char ch : sca) {
            map[ch-'a']++;    
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (map[i] == 1) res = Math.min(res, s.indexOf((char)(i + 'a')));
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
