public class Solution {
    /**
     *  2. Two pointers, one HashMap
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        char[] sca = s.toCharArray();
        int j = -1;
        int maxLen = Integer.MIN_VALUE;
        
        for (int i = 0; i < sca.length; i++) {
            if (map.containsKey(sca[i])) {
                j = Math.max(j, map.get(sca[i]));
            }
            maxLen = Math.max(maxLen, i - j);
            map.put(sca[i], i);
        }
        
        return maxLen;
    }
    
    /**
     *  1. Brute Force
     *  Time complexity -> O(n^2)
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        char[] sca = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int maxLen = 1;
        
        for (int i = 0; i < sca.length; i++) {
            set.clear();
            int end = i;
            for (; end < sca.length; end++) {
                if (set.contains(sca[end])) {
                    maxLen = Math.max(maxLen, end - i);
                    break;
                }
                set.add(sca[end]);
            }
            if (end == sca.length) maxLen = Math.max(maxLen, end - i);
        }
        
        return maxLen;
    }
}
