public class Solution {
    /**
     *  Two pointers + map-like array
     *  Time complexity -> O(n) , in worst case -> O(n^2)
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int counter = 0;
        int max = Integer.MIN_VALUE;
        int[] map = new int[128];
        char[] sca = s.toCharArray();
        int begin = 0;
        int end = 0;
        
        while (end < sca.length) {
            /* meet a new character, we add one to counter */
            if (map[sca[end]] == 0) {
                counter++;
            }
            map[sca[end]]++;
            end++;
            
            /* when there are 3 distinct characters */
            while (counter > 2) {
                map[sca[begin]]--;
                /* map[sca[begin]] == 0 means that we have taken out one characters from current range */
                if (map[sca[begin]] == 0) {
                    counter--;
                }
                begin++;
            }
            
            max = Math.max(max, end - begin);
        }
        
        return max;
    }
}
