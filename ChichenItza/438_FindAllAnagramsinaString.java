public class Solution {
    /**
     * Idea -> Sliding window
     * Time complexity -> O(n)
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return res;
        
        /* record each character in p to hash */
        int[] hash = new int[256];
        for (char ch : p.toCharArray()) hash[ch]++;
        
        int left = 0;
        int right = 0;
        int count = p.length();
        
        while (right < s.length()) {
            /* move right pointer every time, if character in right position is in p's hash, decrease count
             * current hash value >= 1 means this character exists in p */
            if (hash[s.charAt(right++)]-- >= 1) count--;
            
            /* count == 0 means all characters in p have been found in s */
            if (count == 0) res.add(left);
            
            /* when right-left == p.length(), we should update left pointer.
             * ++ to reset the hash because we kick out the character on left pointer.
             * only increase the count when the character been kicked out is in p, 
             * which indicates by hash value >= 0. */
            if (right-left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        
        return res;
    }
}
