public class Solution {
    /**
     *  Brute force -> TLE .. expected..
     */
    // public int lengthOfLongestSubstringKDistinct(String s, int k) {
    //     if (s == null || s.length() == 0 || k == 0) return 0;
        
    //     int res = Integer.MIN_VALUE;
    //     Set<Character> set = new HashSet<>();
        
    //     for (int i = 0; i < s.length(); i++) {
    //         set.clear();
    //         for (int j = i; j < s.length(); j++) {
    //             char ch = s.charAt(j);
    //             set.add(ch);
    //             if (set.size() > k) break;
    //             res = Math.max(res, j - i + 1);
    //         }
    //     }
        
    //     return res == Integer.MIN_VALUE ? s.length() : res;
    // }
    
    /**
     *  Sliding window
     *  Time complexity -> O(n * w), where w is the window size
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) map.remove(leftChar); 
                }
                left++;
            }
            
            res = Math.max(res, i - left + 1);
        }
        
        return res;
    }
}
