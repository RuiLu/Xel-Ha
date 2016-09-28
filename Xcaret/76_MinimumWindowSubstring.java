public class Solution {
    /**
     *  Reference -> https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems
     *  1. Two Pointers;
     *  2. Map;
     *  Time complexity -> O(n)
     */
    public String minWindow(String s, String t) {
        int minIndex = 0;
        int minLen = Integer.MAX_VALUE;
        int counter = 0;
        int begin = 0;
        int end = 0;
        int[] map = new int[128];
        char[] sca = s.toCharArray();
        
        for (char ch : t.toCharArray()) {
            map[ch]++;
            counter++;
        }
        
        while (end < sca.length) {
            /* when we meet a valid character in t */
            if (map[sca[end]] > 0) {
                counter--;
            }
            
            /* deduct the meeting character by one, and move 'end' right */
            map[sca[end]]--;
            end++;
            
            /* found all characters from t */
            while (counter == 0) {
                if (end - begin < minLen) {
                    minIndex = begin;
                    minLen = end - begin;
                }
                
                if (map[sca[begin]] == 0) {
                    counter++;
                }
                map[sca[begin]]++;
                begin++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minIndex, minIndex + minLen);
    }
}
