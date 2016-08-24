public class Solution {
    /**
     *  Time complexity -> O(n)?, it should be bigger than O(n), since I use while-look to look back
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return 0;
        if (s.length() == 0 || s.length() == 1 || s.length() == 2) return s.length();
        
        int res = Integer.MIN_VALUE;
        int left = -1;
        char prev = '\0';
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i > 0) prev = s.charAt(i-1);
            
            set.add(ch);
            if (set.size() > 2) {
                left = i - 1;
                while (left >= 0 && s.charAt(left) == prev) left--;
                if (left == -1) left++;
                set.remove(s.charAt(left));
            }
            res = Math.max(res, i - left);
        }
        
        return res == Integer.MIN_VALUE ? 0 : res;
    }
    
    /**
     *  Time complexity -> O(n)!, because we use HashMap to retrieve the index, so it only takes O(1) time
     * 
     *  There is one thing to point out that the time complexity should be O(kn), where k is the size of map, however,
     *  in this question, k is equal to 2, so the final time complexity is O(2n) = O(n).
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return 0;
        if (s.length() <= 2) return s.length();
        
        int lo = 0;
        int hi = 0;
        int res = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while (hi < s.length()) {
            if (map.size() <= 2) {
                map.put(s.charAt(hi), hi);
                hi++;
            }
            if (map.size() > 2) {
                int leastIndex = s.length();
                for (int index : map.values()) {
                    leastIndex = Math.min(leastIndex, index);
                }
                char removeChar = s.charAt(leastIndex);
                map.remove(removeChar);
                lo = leastIndex + 1;
            }
            
            res = Math.max(res, hi - lo);
        }
        
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
