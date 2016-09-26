public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems
     *  1. Two Pointers;
     *  2. Map;
     *  Time complexity -> O(n)
     */
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int counter = t.length();
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        char[] sca = s.toCharArray();
        
        for (char ch : t.toCharArray()) {
            map[ch]++;
        }
        
        while (end < sca.length) {
            if (map[sca[end]] > 0) {
                counter--;
            }
            map[sca[end]]--;
            end++;
            
            while (counter == 0) {
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                
                map[sca[start]]++;
                if (map[sca[start]] > 0) {
                    counter++;
                }
                start++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
