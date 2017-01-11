public class Solution {
    /**
     *  Time complexity -> O(n)
     *  Space complexity -> O(n)
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        
        int lo = 0;
        int hi = s.length()-1;
        char[] sc = s.toCharArray();
        
        while (lo < hi) {
            while (lo < hi && sc[lo] != 'a' && sc[lo] != 'e' && sc[lo] != 'i' && sc[lo] != 'o' && sc[lo] != 'u' &&
                   sc[lo] != 'A' && sc[lo] != 'E' && sc[lo] != 'I' && sc[lo] != 'O' && sc[lo] != 'U') {
                lo++;        
            }
            while (lo < hi && sc[hi] != 'a' && sc[hi] != 'e' && sc[hi] != 'i' && sc[hi] != 'o' && sc[hi] != 'u' &&
                   sc[hi] != 'A' && sc[hi] != 'E' && sc[hi] != 'I' && sc[hi] != 'O' && sc[hi] != 'U') {
                hi--;           
            }
            
            if (lo >= hi) break;
            
            char tmp = sc[lo];
            sc[lo] = sc[hi];
            sc[hi] = tmp;
            lo++;
            hi--;
        }
        
        return new String(sc);
    }
}
