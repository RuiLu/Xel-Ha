public class Solution {
    /**
     *  Idea -> Use a Map Array to record the appearing time of each character
     *  Time complexity -> O(n)
     *  Space complexity -> O(26)
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        
        int index = Integer.MAX_VALUE;
        int[] map = new int[26];
        
        for (char ch : s.toCharArray()) {
            map[ch-'a']++;
        }
        
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                index = Math.min(index, s.indexOf((char)(i + 'a')));
            }
        } 
        
        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
